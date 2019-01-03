package org.kkorbacz.features

import java.io.File

fun main(args: Array<String>) {

    // [e, b, c, d]
    "abcd".map { if (it == 'a') 'e' else it }

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
        // mention also about also let and run
        StringBuilder().apply(builderAction).toString()