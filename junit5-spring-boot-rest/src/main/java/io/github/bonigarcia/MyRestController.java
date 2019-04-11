
package io.github.bonigarcia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return libraryService.getBooks();
    }

    @RequestMapping(value = "/book/{index}", method = RequestMethod.GET)
    public Book getTeam(@PathVariable("index") int index) {
        return libraryService.getBook(index);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addBook(@RequestBody Book book) {
        libraryService.addBook(book);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

}
