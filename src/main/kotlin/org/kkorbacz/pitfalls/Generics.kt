package org.kkorbacz.pitfalls

class Processor<T> {
    fun process(value: T) {
        value?.hashCode()   // it would not emit any warning if dot is used
    }
}

class SafeProcessor<T: Any> {
    fun process(value: T) {
        value.hashCode()
    }
}

fun main(args: Array<String>) {
    val processor = Processor<String?>()
    processor.process(null)

    // Type argument is not within its bounds: should be subtype of 'Any'
    // val safeProcessor = SafeProcessor<String?>()
}