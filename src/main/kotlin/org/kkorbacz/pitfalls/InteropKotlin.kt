package org.kkorbacz.pitfalls

data class Person(val name: String)

data class CustomResponse(val items: List<Person>)

// dummy implementation of some generic rest client
abstract class RestClient {
    fun performGetRequest() : Promise<CustomResponse> {
        println("Performing get request ...")
        return Promise(CustomResponse(emptyList()))
    }
}

interface OurRestClient {
    fun getPerson(): Promise<Person>
}

// non-nullable return type, but in fact null is returned inside of promise
// and decision about how to treat the platform type is made for us in an interface: OurRestClient
// in effect when e.g. using code completion for override we can omit important decision point and get painful NPE in future
class OurRestClientImpl : OurRestClient, RestClient() {
    override fun getPerson(): Promise<Person> {
        return performGetRequest()
                .map { it -> it.items.firstOrNull() }
    }
}

fun main(args: Array<String>) {

    // ***** 1 *****
    val objectUnderTest = InteropJava(null)

    val integerField = objectUnderTest.integerField

    // java.lang.NullPointerException
    integerField * 2

    // ***** 2 *****
    val list = listOf("first elem", "second elem", "third elem")
    // list.set <-- there is no such method in Kotlin read-only view

    // [first elem, second elem, third elem]
    println(list)

    objectUnderTest.dreadfulMethod(list)

    // [Nobody expects that I was added to the collection, second elem, third elem]
    println(list)

    // ***** 3 *****
    // java.lang.NullPointerException
    OurRestClientImpl().getPerson().value.name.toUpperCase()
}