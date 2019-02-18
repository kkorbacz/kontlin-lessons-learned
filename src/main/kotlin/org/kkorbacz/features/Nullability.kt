package org.kkorbacz.features

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    val nonNullableVariable: String = "hello"
    println(nonNullableVariable) // hello

    val nullString: String? = null
    val result = nullString?.toUpperCase()?.trim() ?: "defaultString"
    println(result) // defaultString

    fun maybeDateAsString(): String? = "2019-01-01"

    val dateAsString = maybeDateAsString()?.let {
        LocalDate.parse(it, DateTimeFormatter.ISO_LOCAL_DATE)
    } ?: LocalDate.now()
    println(dateAsString) // 2019-01-01
}