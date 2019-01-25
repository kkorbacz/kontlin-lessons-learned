package org.kkorbacz.recipes

const val TOP_PRIMITIVE = 1         // same as class with public static final in Java

val TOP_VAL_WITHOUT_CONST = 1       // compiled to private static final and corresponding getter

//const val TOP_OBJECT = Pair(1, 1) // compilation error: only primitives and String are allowed


class SomeClass {
//  const val CLASS_CONST = 1       //compilation error: const vals are allowed only on top level or in objects

    val CLASS_PRIMITIVE = 1

    val CLASS_OBJECT = Pair(1, 1)

    companion object Consts {
        const val COMPANION_PRIMITIVE = 1       // public static final field on Consts level
                                                // public static final Companion object

//      const val COMPANION_OBJECT = Pair(1, 1) // compilation error: only primitives and String are allowed

        val COMPANION_OBJECT = Pair(1, 1)   // private static final field on Consts level
                                                // public static final Companion object
                                                // the Companion object itself has a getter

        @JvmField val FOO = Pair(1, 1)      // a way to make Object public static final, still Companion object is created
                                                // Consts.FOO does not get inlined
    }
}

object SomeObject {
    const val OBJECT_PRIMITIVE = 1          // public static final field

//  const val OBJECT_OBJECT = Pair(1, 1)    // compilation error: only primitives and String are allowed
}
