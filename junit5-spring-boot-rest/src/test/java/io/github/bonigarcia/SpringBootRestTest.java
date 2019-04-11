
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class SpringBootRestTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testGetAllBooks() {
        ResponseEntity<Book[]> responseEntity = restTemplate
                .getForEntity("/books", Book[].class);

        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals(3, responseEntity.getBody().length);
    }

    @Test
    void testGetBook() {
        ResponseEntity<Book> responseEntity = restTemplate
                .getForEntity("/book/0", Book.class);

        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals("The Hobbit", responseEntity.getBody().getName());
    }

    @Test
    void testPostBook() {
        Book book = new Book("I, Robot", "Isaac Asimov",
                LocalDate.of(1950, 12, 2));
        ResponseEntity<Boolean> responseEntity = restTemplate
                .postForEntity("/book", book, Boolean.class);
        assertEquals(CREATED, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());

        ResponseEntity<Book[]> responseEntity2 = restTemplate
                .getForEntity("/books", Book[].class);
        assertEquals(responseEntity2.getBody().length, 4);
    }

}
