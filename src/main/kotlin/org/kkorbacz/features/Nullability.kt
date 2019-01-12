package org.kkorbacz.features

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    // defaultString
    val nullString: String? = null
    nullString?.toUpperCase()?.trim() ?: "defaultString"

    // 2019-01-01
    maybeDateAsString()?.let {
        LocalDate.parse(it, DateTimeFormatter.ISO_LOCAL_DATE)
    } ?: LocalDate.now()

}

private fun maybeDateAsString(): String? = "2019-01-01"