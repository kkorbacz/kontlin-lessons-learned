package org.kkorbacz.features

import kotlin.properties.Delegates

@Suppress("unused")
object SimpleSingleton {
    const val answer = 42
    fun greet(name: String) = "Hello, $name!"
}

@Suppress("unused")
class Builder(
        val name: String,
        val lastName: String,
        val email: String? = null,
        val hobby: List<String> = emptyList(),
        val acceptedNewsletter: Boolean = false)

// cumbersome and not thread-safe
@Suppress("unused")
class User(val name: String) {
    private var _emails: List<String>? = null

    val emails: List<String>
        get() {
            if (_emails == null) {
                _emails = loadEmails()
            }
            return _emails!!
        }

    private fun loadEmails() = listOf("First email from DB", "Second email from DB")
}

// wow :)
class BetterUser(val name: String) {
    val emails by lazy { loadEmails() }

    private fun loadEmails() = listOf("First email from DB", "Second email from DB")
}

interface Listener {
    fun onChange(newValue: String)
}

class PrintingListener : Listener {
    override fun onChange(newValue: String) {
        println("New text: $newValue")
    }
}

class ObservableObject(listener: Listener) {
    var value: String by Delegates.observable(
            initialValue = "initial value",
            onChange = { _, _, newValue -> listener.onChange(newValue) })
}

fun main(args: Array<String>) {
    SimpleSingleton.greet("Krzysztof")

    Builder("Pawel", "Doe")
    Builder("Krzysztof", "Doe", acceptedNewsletter = true)

    val user = BetterUser("Stefan")
    println("${user.name} emails: ${user.emails}")

    val observableObject = ObservableObject(PrintingListener())
    observableObject.value = "First value"
    observableObject.value = "Second value"
}