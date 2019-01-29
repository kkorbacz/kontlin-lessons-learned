package org.kkorbacz.features

data class Person(val firstName: String, val lastName: String, val age: Int)

fun main(args: Array<String>) {
    val person = Person("John", "Doe", 27)

    // Person(firstName=John, lastName=Doe, age=27)
    println(person)

    val (firstName, lastName) = person

    // John, Doe
    println("$firstName, $lastName")

    val personCopy = person.copy(firstName = "Jane")
    // Person(firstName=Jane, lastName=Doe, age=27)
    println(personCopy)

    // false
    println("${personCopy == person}")
}

