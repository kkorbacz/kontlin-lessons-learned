package org.kkorbacz.features

sealed class Operation

// subclasses of Operation can be defined only in this file
class Deletion(val id: Int) : Operation()

class Addition(val name: String) : Operation()
class Update(val id: Int, val name: String) : Operation()

fun main(args: Array<String>) {
    perform(Deletion(1))
}

// no need for else clause
private fun perform(operation: Operation) =
        when (operation) {
            is Deletion -> println("deleted record with id: ${operation.id}")
            is Addition -> println("added new record with name: ${operation.name}")
            is Update -> println("updated record with id: ${operation.id} to have name: ${operation.name}")
        }


