package org.kkorbacz.features

import java.io.File
import java.time.LocalDate

fun main(args: Array<String>) {

    // false
    "abcd".isBlank()

    // 2
    listOf(1, 2).max()

    // the-file
    File("/home/username/the-file.txt").nameWithoutExtension

    // true
    LocalDate.now().isAfterOrEqual(LocalDate.of(2019, 1,1))

    // abcdef
    buildString {
        append("abcd")
        append("ef")
    }

    // lambda with receiver & apply extension function
    fun buildString(builderAction: StringBuilder.() -> Unit): String =
            StringBuilder().apply(builderAction).toString()

    // [20, 24, 28]
    listOf(5, 6, 7) * 4
}

// can be called on an object variable even if its value is null
fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}

fun LocalDate.isAfterOrEqual(other: LocalDate): Boolean = this.isAfter(other) || this.isEqual(other)

operator fun List<Int>.times(by: Int): List<Int> {
    return this.map { it * by }
}

class Column<T>

// member extensions can't be called outside of their applicability scope
open class Table {
    fun <T> Column<T>.primaryKey(): Column<T> = Column()
    // restricting receiver type
    fun Column<Int>.autoIncrement(): Column<Int> = Column()

    fun integer(name: String): Column<Int> = Column()
    fun varchar(name: String, length: Int): Column<String> = Column()
}

object Country : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val name = varchar("name", 50)
}
