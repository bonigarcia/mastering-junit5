# [![][Logo]][GitHub Repository]

[![Build Status](https://travis-ci.org/bonigarcia/mastering-junit5.svg?branch=master)](https://travis-ci.org/bonigarcia/mastering-junit5)
[![License badge](https://img.shields.io/badge/license-Apache2-green.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Support badge](https://img.shields.io/badge/stackoverflow-junit5-green.svg)](http://stackoverflow.com/questions/tagged/junit5)
[![Twitter Follow](https://img.shields.io/twitter/follow/boni_gg.svg?style=social)](https://twitter.com/boni_gg)

This repository contains code examples of [JUnit 5] for the book [Mastering Software Testing with JUnit 5], authored by [Boni Garcia] and published by [Packt]. These examples covers the main features of JUnit 5, such as:

* JUnit 5 tests lifecycle.
* Assertions.
* Tagging and filtering tests.
* Conditional test execution.
* Nested and repeated tests.
* Migration from JUnit 4.
* Dependency injection.
* Dynamic tests.
* Test interfaces.
* Test templates.
* Parameterized tests.
* Parallel execution.
* Ordered tests.

Moreover, the integration with third-party frameworks and technologies is also illustrated with examples, concretely:

* Mockito (popular mock framework).
* Spring (Java framework aimed to created enterprise applications based on dependency injection).
* Docker (container platform technology).
* Selenium (test framework for web applications).
* Appium (driver for mobile devices).
* Android (open source mobile operating system based on Linux).
* REST services (using REST Assured, Retrofit2, or WireMock).

# JUnit 5 versions

This repository has different tags, one per minor version of JUnit 5. Currently, the available tags are the following:

* `5.0`: Examples using JUnit 5.0.3. The examples of the book [Mastering Software Testing with JUnit 5] are based on this version.
* `5.1`: Examples using JUnit 5.1.1.
* `5.2`: Examples using JUnit 5.2.0.
* `5.3`: Examples using JUnit 5.3.2.
* `5.4`: Examples using JUnit 5.4.2.
* `5.5`: Examples using JUnit 5.5.2.
* `5.6`: Examples using JUnit 5.6.2.

# Complete example

The project [Rate my cat!] contains a sample web application based on Spring Boot (Spring MVC, Thymeleaf, and Spring Data JPA)
with a complete set of JUnit 5 tests (unit with Mockito, integration with Spring, and end-to-end tests with Selenium).  

# About

This is a project made by [Boni Garcia], Assistant Professor at [Universidad Carlos III de Madrid], Spain. Copyright &copy; 2017-2021.

[JUnit 5]: http://junit.org/junit5/
[Boni Garcia]: http://bonigarcia.github.io/
[Universidad Carlos III de Madrid]: http://www.it.uc3m.es/bogarcia/index.html
[Logo]: http://bonigarcia.github.io/img/mastering_junit5_logo.png
[GitHub Repository]: https://github.com/bonigarcia/mastering-junit5
[Mastering Software Testing with JUnit 5]: https://www.amazon.com/Mastering-Software-Testing-JUnit-Comprehensive-ebook/dp/B076ZQCK5Q
[Packt]: https://www.packtpub.com/web-development/mastering-software-testing-junit-5
[Rate my cat!]: https://github.com/bonigarcia/rate-my-cat
