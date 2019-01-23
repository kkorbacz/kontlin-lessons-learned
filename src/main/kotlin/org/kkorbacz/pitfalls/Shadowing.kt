package org.kkorbacz.pitfalls


fun someFunction() = 1
val someVariable = 1


fun test(arg: Int) {
    println(arg)    // prints  1
    val arg = 2     // highlights with warning: Name shadowed
    println(arg)    // prints 2
}

fun main(args: Array<String>) {
    test(1)

    println(someVariable) // prints  1
    val someVariable = 2 // no warning
    println(someVariable) // prints  2

    println(someFunction()) // prints  1
    fun someFunction() = 2 // no warning
    println(someFunction()) // prints  2
}