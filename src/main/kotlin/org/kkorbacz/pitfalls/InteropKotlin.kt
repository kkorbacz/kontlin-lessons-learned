package org.kkorbacz.pitfalls

fun main(args: Array<String>) {

    // ***** 1 *****
    val objectUnderTest = InteropJava(null)

    val integerField = objectUnderTest.integerField

    // java.lang.NullPointerException
    integerField.times(2)

    // ***** 2 *****
    val list = listOf("first elem", "second elem", "third elem")
    // list.set <-- there is no such method in Kotlin read-only view

    // [first elem, second elem, third elem]
    println(list)

    objectUnderTest.dreadfulMethod(list)

    // [Nobody expects that I was added to the collection, second elem, third elem]
    println(list)
}