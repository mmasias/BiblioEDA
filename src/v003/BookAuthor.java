package v003;

class BookAuthor {
    private Book book;
    private Author author;

    public BookAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    public int getBookId() {
        return book.getId();
    }

    public int getAuthorId() {
        return author.getId();
    }
}
