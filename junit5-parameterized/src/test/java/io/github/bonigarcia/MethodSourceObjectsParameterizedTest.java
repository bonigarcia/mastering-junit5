
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MethodSourceObjectsParameterizedTest {

    static Stream<Person> personProvider() {
        Person john = new Person("John", "Doe");
        Person jane = new Person("Jane", "Roe");
        return Stream.of(john, jane);
    }

    @ParameterizedTest
    @MethodSource("personProvider")
    void testWithPersonProvider(Person argument) {
        System.out.println(
                "Parameterized test with (Person) argument: " + argument);
        assertNotNull(argument);
    }

    static class Person {

        String name;
        String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", surname=" + surname + "]";
        }

    }

}
