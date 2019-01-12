package org.kkorbacz.pitfalls

fun main(args: Array<String>) {

    val objectUnderTest = InteropJava(null)

    val integerField = objectUnderTest.integerField
    integerField.times(2)
}