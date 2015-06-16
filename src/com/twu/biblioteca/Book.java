package com.twu.biblioteca;

public class Book {

    private String name, author, year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String formattedBookDetails(int maximumNameLength, int maximumAuthorLength) {
        return String.format("%-" + maximumNameLength + "s", name)
                + " | " +
                String.format("%-" + maximumAuthorLength + "s", author)
                + " | " +
                year;
    }

    public int nameLength() {
        return name.length();
    }

    public int authorLength() {
        return author.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Book book = (Book) o;

        return !(name != null ? !name.equals(book.name) : book.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public boolean isSameBook(String bookName) {
        return name == bookName;
    }

    public void appendToBooks(BooksPresenter booksPresenter) {
        booksPresenter.addBook(name, author, year);
    }
}
