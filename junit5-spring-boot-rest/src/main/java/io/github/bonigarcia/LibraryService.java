/*
 * (C) Copyright 2017 Boni Garcia (https://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

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
