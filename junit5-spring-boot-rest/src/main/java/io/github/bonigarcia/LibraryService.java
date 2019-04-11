
package io.github.bonigarcia;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    private List<Book> books = new ArrayList<>();

    @PostConstruct
    private void populateLibrary() {
        addBook(new Book("The Hobbit", "J. R. R. Tolkien",
                LocalDate.of(1937, 2, 21)));
        addBook(new Book("A Confederacy of Dunces", "John Kennedy Toole",
                LocalDate.of(1980, 4, 1)));
        addBook(new Book("A Game of Thrones (A Song of Ice and Fire)",
                "George R.R. Martin", LocalDate.of(1996, 1, 1)));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        books.remove(index);
    }

}
