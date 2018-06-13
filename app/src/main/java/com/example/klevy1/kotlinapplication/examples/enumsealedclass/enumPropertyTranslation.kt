package com.example.klevy1.kotlinapplication.examples.enumsealedclass

class EnumPropertyTranslation {
    // "Main" method to run translation
    fun runTranslation() {
        println(firstToSecond("hello"))
        println(firstToSecond("bye"))
        println(firstToSecond("invalid"))

        println(secondToFirst("hey"))
        println(secondToFirst("goodbye"))
        println(secondToFirst("invalid"))
    }

    // The enum class with various constants
    // Assumption: each enum constant has unique properties
    // ie. ONE's first property is different to TWO's first property
    enum class Example(val first : String, val second : String) {
        ONE("hello", "hey"),
        TWO("bye", "goodbye");
    }


    // Return the first property when given the second property
    // Non Functional Approach
    fun secondToFirst(input : String) : String {
        for (exampleEnum in Example.values()) {
            if (exampleEnum.second == input) {
                return exampleEnum.first
            }
        }
        return "Does not match enum"
    }

    // Return the second property when given the first property
    // Functional Approach
    fun firstToSecond(input : String) : String {
        val enumResult : Example? = Example.values().filter { it.first == input}.firstOrNull()
        return enumResult?.second ?: "Does not match enum"
    }

}