package org.kkorbacz.recipes


class ConstructorValidated {
    val number: Int

    constructor(number: Int) { // IDE suggests to convert to init block way
        check(number > 0) { "Expected number greater than zero" }
        this.number = number
    }
}

class InitBlockValidated(val number: Int) { // You can't add any extra code here
    init {
        check(number > 0) { "Expected number greater than zero" }
    }
}

class CompanionObjectValidated private constructor(val number: Int) {
    companion object {
        fun create(number: Int): CompanionObjectValidated {
            check(number > 0) { "Expected number greater than zero" }
            return CompanionObjectValidated(number)
        }
    }
}


fun main(args: Array<String>) {
    println(ConstructorValidated(1).number)
    println(InitBlockValidated(1).number)
    println(CompanionObjectValidated.create(1).number)

    try {
        ConstructorValidated(-1)
    } catch (e: Exception) {
        e.printStackTrace()  // at org.kkorbacz.recipes.ConstructorValidated.<init>
    }

    try {
        InitBlockValidated(-1)
    } catch (e: Exception) {
        e.printStackTrace() // at org.kkorbacz.recipes.InitBlockValidated.<init>
    }

    try {
        CompanionObjectValidated.create(-1)
    } catch (e: Exception) {
        e.printStackTrace() // at org.kkorbacz.recipes.CompanionObjectValidated$Companion.create
    }
}
