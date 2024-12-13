package com.example.kotlin_classes.abschluss_abgabe


/**
 * Represents a library that manages a collection of books and allows members to borrow and reserve them.
 */
class Library {
    /**
     * A private mutable list that stores all the books in the library.
     */
    private val books = mutableListOf<Book>()

    /**
     * A nested class that represents the address of the library.
     */
    class LibraryAddress(
        private val street: String,
        private val city: String,
        private val zipCode: String
    ) {
        /**
         * Prints the address of the library in a formatted string.
         */
        fun printAddress() {
            println("Library Address: $street, $city, $zipCode")
        }
    }


    /**
     * An inner class that represents a member of the library.
     */
    inner class LibraryMember(private val name: String, private val memberID: String) {
        /**
         * Attempts to checkout a book for the member.
         *
         * @param book The book the member wants to checkout.
         * @param dueDate The date the book is due back.
         *
         * This method checks if the book is available and updates its status to CheckedOut
         * if successful. Otherwise, it prints a message indicating the book's current status.
         */
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out '${book.title}' until $dueDate.")
            } else {
                println("Cannot checkout '${book.title}'. It is currently ${book.status.updateStatus()}.")
            }
        }
        /**
         * Attempts to reserve a book for the member.
         *
         * @param book The book the member wants to reserve.
         *
         * This method checks if the book is available and updates its status to Reserved
         * if successful. Otherwise, it prints a message indicating the book's current status.
         */
        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved '${book.title}'.")
            } else {
                println("Cannot reserve '${book.title}'. It is currently ${book.status.updateStatus()}.")
            }
        }
    }

    /**
     * Adds a new book to the library's collection.
     *
     * @param book The book to be added.
     *
     * This method adds the book to the `books` list and prints a confirmation message.
     */
    fun addBook(book: Book) {
        books.add(book)
        println("Book '${book.title}' by ${book.author} added to the library.")
    }

    /**
     * Searches for books by title or author (case-insensitive).
     *
     * @param query The search term.
     *
     * This method filters the `books` list based on whether the title or author
     * contains the search term (ignoring case) and returns a list of matching books.
     */
    fun searchBooks(query: String): List<Book> {
        return books.filter { it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true) }
    }

    /**
     * Displays the current status of all books in the library.
     *
     * This method iterates through the `books` list and for each book, prints its title,
     * author, and current status retrieved from the `updateStatus` method of the `BookStatus` class.
     */
    fun displayBookStatuses() {
        books.forEach { book ->
            println("${book.title} by ${book.author}: ${book.status.updateStatus()}")
        }
    }
}

