package org.kkorbacz.recipes

private data class SomeDataClass(val someField: Int)

fun main(args: Array<String>) {
    // Kotlin reflection API
    println(SomeDataClass::class.isData)
    println(SomeDataClass::class.isCompanion)

    // Java reflection API
    println(SomeDataClass::class.java.canonicalName)
    println(SomeDataClass::class.java.isAnnotation)
}