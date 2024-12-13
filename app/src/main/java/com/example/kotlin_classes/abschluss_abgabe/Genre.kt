package com.example.kotlin_classes.abschluss_abgabe

/**
 * Represents the genre of a book.
 * @property description A brief description of the genre.
 */
enum class Genre(val description: String) {
    FICTION("Fictional stories"),
    NON_FICTION("Factual accounts"),
    SCIENCE("Knowledge and study of the natural world"),
    HISTORY("Study of past events"),
    CHILDREN("Content for children");

    /**
     * Prints the description of the genre.
     */
    fun printDescription() {
        println(description)
    }
}