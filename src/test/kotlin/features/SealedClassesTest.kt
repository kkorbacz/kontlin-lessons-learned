package features

import io.kotlintest.specs.FunSpec

// naturally there is no way to test private functions ; workaround for lack of package private
// i.e. creating single file with multiple classes and functions (and some of them are private) can impact testability
class SealedClassesTest : FunSpec({
    test("perform should delete and object with given id when Deletion Operation passed as arg") {
        // perform(Deletion(23))
    }
})