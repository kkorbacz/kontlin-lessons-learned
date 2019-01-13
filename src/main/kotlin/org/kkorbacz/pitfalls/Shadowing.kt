package org.kkorbacz.pitfalls


fun someFunction() = "Some message from first function"

abstract class SomeAbstractClassWithLambda(val someLabmda: () -> Unit)

class SomeImplementation: SomeAbstractClassWithLambda({

    println(someFunction()) // uses top level function above

    fun someFunction() = "LOL, I'm the JavaScript ¯\\_(ツ)\\_/¯"

    println(someFunction()) // uses local function
})


fun main(args: Array<String>) {
    SomeImplementation().someLabmda.invoke()
}