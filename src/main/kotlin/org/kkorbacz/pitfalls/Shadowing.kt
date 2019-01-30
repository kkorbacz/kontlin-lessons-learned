package org.kkorbacz.pitfalls

fun test(arg: Int) {
    println(arg)    // prints  1
    val arg = 2     // at least highlights with warning: Name shadowed
    println(arg)    // prints 2
}

fun main(args: Array<String>) {
    test(1)

    println(someFunction())     // prints  1
    fun someFunction() = 2  // no warning at all!
    println(someFunction())     // prints  2

    println(someVariable)       // prints  1
    val someVariable = 2        // no warning at all!
    println(someVariable)       // prints  2
}