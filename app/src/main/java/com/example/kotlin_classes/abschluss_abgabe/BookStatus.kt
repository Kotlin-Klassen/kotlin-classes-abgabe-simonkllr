package com.example.kotlin_classes.abschluss_abgabe

/**
 * Represents the status of a book.
 */
sealed class BookStatus {
    object Available : BookStatus()
    data class CheckedOut(val dueDate: String) : BookStatus()
    data class Reserved(val reservedBy: String) : BookStatus()

    /**
     * Returns a human-readable string representing the current status.
     */
    fun updateStatus(): String {
        return when (this) {
            is Available -> "Book is available for checkout."
            is CheckedOut -> "Book is currently checked out, due back on $dueDate."
            is Reserved -> "Book is reserved by $reservedBy."
        }
    }
}

