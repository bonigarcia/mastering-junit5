
package io.github.bonigarcia;

import java.time.LocalDate;

public class Book {

    private String name;
    private String author;
    private LocalDate publicationDate;

    public Book() {
    }

    public Book(String name, String author, LocalDate publicationDate) {
        super();
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

}
