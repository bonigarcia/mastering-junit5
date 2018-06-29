# [![][Logo]][GitHub Repository]

[![Build Status](https://travis-ci.org/bonigarcia/mastering-junit5.svg?branch=master)](https://travis-ci.org/bonigarcia/mastering-junit5)
[![License badge](https://img.shields.io/badge/license-Apache2-green.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Twitter](https://img.shields.io/badge/follow-@boni_gg-green.svg)](https://twitter.com/boni_gg)

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

* `5.0`: Examples using JUnit 5.0.x. The examples of the book [Mastering Software Testing with JUnit 5] are based on this version.
* `5.1`: Examples using JUnit 5.1.x.
* `5.2`: Examples using JUnit 5.2.x.

# Complete example

The project [Rate my cat!] contains a sample web application based on Spring Boot (Spring MVC, Thymeleaf, and Spring Data JPA)
with a complete set of JUnit 5 tests (unit with Mockito, integration with Spring, and end-to-end tests with Selenium).  

# About

This is a project made by [Boni Garcia], Assistant Professor at [U-tad] and Researcher at [Universidad Rey Juan Carlos], Spain. Copyright &copy; 2017-2018.

[JUnit 5]: http://junit.org/junit5/
[Boni Garcia]: http://bonigarcia.github.io/
[U-tad]: http://www.u-tad.com/
[Universidad Rey Juan Carlos]: https://www.urjc.es/
[Logo]: http://bonigarcia.github.io/img/mastering_junit5_logo.png
[GitHub Repository]: https://github.com/bonigarcia/mastering-junit5
[Mastering Software Testing with JUnit 5]: https://www.amazon.com/gp/product/1787285731/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=1787285731&linkCode=as2&tag=boni0a-20&linkId=a0b9a99160003dfd49a797906e8c191b
[Packt]: https://www.packtpub.com/books/info/authors/boni-garc%C3%AD
[Rate my cat!]: https://github.com/bonigarcia/rate-my-cat
