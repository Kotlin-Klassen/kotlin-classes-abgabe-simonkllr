package com.example.kotlin_classes.abschluss_abgabe

fun main() {
    // Create library instance
    val library = Library()

    // Add library address
    val address = Library.LibraryAddress("Dieter Schwarz Str.", "Heilbronn", "74076")
    address.printAddress()

    // Add books to the library
    library.addBook(Book("Boxkampf", "Stefan Raab", Genre.FICTION, BookStatus.Available))
    library.addBook(Book("Computer Science", "Elon Musk", Genre.SCIENCE, BookStatus.Available))
    library.addBook(Book("Freiheit", "Frau Merkel", Genre.CHILDREN, BookStatus.Available))

    // Create a library member
    val member = library.LibraryMember("Max Mustermann", "M001")

    // Member checks out and reserves books
    val bookToCheckout = library.searchBooks("Freiheit").first()
    member.checkoutBook(bookToCheckout, "2024-12-31")

    val bookToReserve = library.searchBooks("Computer Science").first()
    member.reserveBook(bookToReserve)

    // Display current status of all books
    println("\n status of all books: ")
    library.displayBookStatuses()
}