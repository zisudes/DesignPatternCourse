package W_6.prototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Prototype {
    private final String title;
    private final String author;
    private final List<String> genres;
    private final int publicationYear;

    private static final ArrayList<Book> allBooks = new ArrayList<>();

    public Book(String title, String author, String genre, int publicationYear) {
        this(title, author, Collections.singletonList(genre), publicationYear);
    }

    public Book(String title, String author, List<String> genres, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genres = genres;
        this.publicationYear = publicationYear;

        allBooks.add(this);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static void deleteBook(Book book) {
        Book.allBooks.remove(book);
    }

    @Override
    public Book clone(){
        return new Book(title, author, genres, publicationYear);
    }

    @Override
    public String toString(){
        return String.format("\"%s\" by %s (%s) %s", title, author, publicationYear, genres);
    }
}
