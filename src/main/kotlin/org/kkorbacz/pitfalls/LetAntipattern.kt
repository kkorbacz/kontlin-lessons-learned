package org.kkorbacz.pitfalls

fun main(args: Array<String>) {

    val somethingNullable = "Data to be consumed"

    // I am doing something with: [Data to be consumed] ...
    // Error handling activity ...
    somethingNullable?.let {
        doSomething(it)
    } ?: errorHandling()
}

fun doSomething(arg: String) : String? {
    println("I am doing something with: [$arg] ...")
    return null
}

fun errorHandling() = println("Error handling activity ...")