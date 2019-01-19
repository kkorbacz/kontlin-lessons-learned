package org.kkorbacz.features

class Car(val model: String, val type: String)

class Car2(val model: String, val type: String) {
    // called after primary constructor, but actually a part of it
    init {
        println("Perform for example some precondition checking for model and type")
    }
}

class Car2a(val model: String, val type: String) {
    constructor(model: String) : this(model, "default")
}

class Car3(model: String)

class Car4(var model: String)

class Car5(val model: String)

class Car6(private var model: String) {

    fun modelInfo() = model.toUpperCase()
}

class Car7(private val model: String) {

    fun modelInfo() = model.toUpperCase()
}

class Car8 {
    val model: String
        get() { return "lancer"}
}

fun main(args: Array<String>) {
    // no getter and setter
    val car3 = Car3("sonata")

    val car4 = Car4("a5")
    car4.model = "a6"
    println(car4.model)

    val car5 = Car5("m5")
    println(car5.model)

    val car6 = Car6("impreza")  // here we have field generated in the class body, similarly for car7
}
