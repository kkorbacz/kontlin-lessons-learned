package org.kkorbacz.recipes

const val TOP_PRIMITIVE = 1
//const val TOP_OBJECT = Pair(1, 1) // compilation error: only primitives and String are allowed

class SomeClass {
//  const val CLASS_CONST = 1 //compilation error: Consts val are allowed only on top level or in objects

    val CLASS_PRIMITIVE = 1
    val CLASS_OBJECT = Pair(1, 1)

    companion object Consts {
        const val COMPANION_PRIMITIVE = 1
//      const val COMPANION_OBJECT = Pair(1, 1) // compilation error: only primitives and String are allowed
        val COMPANION_OBJECT = Pair(1, 1)
    }
}

object SomeObject {
    const val CLASS_PRIMITIVE = 1
//  const val CLASS_OBJECT = Pair(1, 1)  // compilation error: only primitives and String are allowed
}