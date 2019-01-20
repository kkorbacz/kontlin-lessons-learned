package org.kkorbacz.pitfalls


fun someFunction() = "Some message from first function"

abstract class SomeAbstractClassWithLambda(val someLabmda: () -> Unit)

class SomeImplementation: SomeAbstractClassWithLambda({

    println(someFunction()) // uses top level function above

    fun someFunction() = "LOL, I'm the JavaScript ¯\\_(ツ)\\_/¯"

    println(someFunction()) // uses local function
})

fun test(arg: Int) {
    println(arg)    // 1
    val arg = 2
    println(arg)    // 2
}

fun main(args: Array<String>) {
    SomeImplementation().someLabmda.invoke()
    test(1)
}
