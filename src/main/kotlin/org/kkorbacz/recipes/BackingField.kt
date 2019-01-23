package org.kkorbacz.recipes

class SomeClassWithField {
    var someVariable = "SomeDefaultValue"
        get() = someVariable // highlights waring: Recursive property accessor
}

class OtherClassWithField {
    var someVariable = "SomeDefaultValue"
        get() = field
}

fun main(args: Array<String>) {
//  SomeClassWithField().someVariable  // compile time StackOverflowError

    OtherClassWithField().someVariable // works great
}