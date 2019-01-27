package org.kkorbacz.pitfalls

data class Person(val name: String)

data class CustomResponse(val items: List<Person>)

fun performGetRequest(): Promise<CustomResponse> {
    return Promise(CustomResponse(emptyList()))
}

// non-nullable return type, but in fact null is returned inside of promise
fun getPromise() : Promise<Person> =
        performGetRequest()
                .map { it -> it.items.firstOrNull() }

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
    getPromise().value.name.toUpperCase()
}