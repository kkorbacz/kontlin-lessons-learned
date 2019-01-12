package org.kkorbacz.features

import java.io.File

fun main(args: Array<String>) {

    // cd
    "abcd".removePrefix("ab")

    // false
    "abcd".isBlank()

    // 2
    listOf(1, 2).max()

    // the-file
    File("/home/username/the-file.txt").nameWithoutExtension

    // abcdef
    buildString {
        append("abcd")
        append("ef")
    }

}

fun buildString(builderAction: StringBuilder.() -> Unit): String =
        StringBuilder().apply(builderAction).toString()