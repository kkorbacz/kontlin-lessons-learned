package org.kkorbacz.pitfalls

fun test1() {
    println(SOME_CONSTANT)
}

// todo [ppyzik] do you remember how was it declared to cause this weird shadowing issue?
//const val SOME_CONSTANT = "The second string"

fun test2() {
    println(SOME_CONSTANT)
}

fun main(args: Array<String>) {
    test1()
    test2()
}