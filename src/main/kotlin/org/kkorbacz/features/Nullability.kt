package org.kkorbacz.features

fun main(args: Array<String>) {
    val nullString : String? = null
    println( nullString?.toUpperCase()?.trim() ?: "defaultString" )
}