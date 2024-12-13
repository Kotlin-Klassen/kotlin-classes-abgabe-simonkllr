package com.example.kotlin_classes.abschluss_abgabe

/**
 * Represents a book with its title, author, genre, and current status.
 * @property title The title of the book.
 * @property author The author of the book.
 * @property genre The genre of the book.
 * @property status The current status of the book (available, checked out, or reserved).
 */
data class Book(
    var title: String,
    var  author: String,
    var genre: Genre,
    var status: BookStatus,
)
