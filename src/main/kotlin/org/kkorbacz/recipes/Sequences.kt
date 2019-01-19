package org.kkorbacz.recipes

fun collection() =
        listOf(1, 2, 3, 4, 5)
                .map { it * it }    // creates another list: [1, 4, 9, 16, 25]
                .find { it > 3 }    // after rejecting 1 finds the result

// similar concept as streams in Java
fun sequence() =
        listOf(1, 2, 3, 4, 5)
                .asSequence()
                .map { it * it }    // 1         |   4
                .find { it > 3 }    // reject 1  |   finds the result