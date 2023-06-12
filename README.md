
# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/gradle-plugin/reference/html/#build-image)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web.reactive)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.sql.r2dbc)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Accessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [R2DBC Homepage](https://r2dbc.io)

### SPRING DATA R2DBC
***Spring boot R2BDC is a module build within the Spring Boot framework that provides support for R2DBC (Reactive Relational Database Connectivity). It enables developers to build reactive applications that interact with relational databases ussing a non-blocking and asynchronous programming model.***
With spring boot R2BDC, you can leverage the benefits of reactive programming , such as handling high concurrency and scalability, while still being able to interact with traditional relational database. It allows you to use the familiar Spring programming model and annotations while integrating with R2DBC drivers for various databases like PostgreSQL, MySQL, SQL Server, and more.
To use Spring Book R2DBC, you typically need to include the necessary dependencies in you project's build configuration , configure the R2DBC connection details in the application properties or YAML file, and then use Spring Data R2DBC or low-level R2DBC APIs to interact with the database.

Spring Data R2DBC provides higher-level abstractions, such as repositories and query methobs, to simplify database operations. It automatically generacts SQL statements based on method names or anotations and provides reactive types, like Mono,and Flux to handle the aysnchronous flow of data.

### Get started 
#### Configure spring data R2DBC
```java
# application.properties
        #spring.data.r2dbc.repositories.enabled=true
        spring.r2dbc.url=r2dbc:postgresql://localhost:5432/mydb
        spring.r2dbc.username=postgres
        spring.r2dbc.password = 2510
```
- Explain: 
- - `spring.data.r2dbc.repositories.enabled` determines the activation of R2DBC repositories in a Spring Boot application.
  By default, R2DBC repository support is enabled in a Spring Boot application. If you want to disable R2DBC repository support, you can set the spring.data.r2dbc.repositories.enabled property to false.
- - `spring.r2dbc.url=r2dbc:postgresql://localhost:5432/mydb` which indicates that you are using a PostgreSQL DB located at local host on port 5432
1. @EnableR2dbcRepositories
   @EnableR2dbcRepositories is a Spring annotation that is used to enable R2DBC repositories in a Spring Boot application. It provides a convenient way to create a repository layer in a Spring Boot application that uses R2DBC to interact with a database.

Because R2DBC repository support is enabled in our Spring Boot application by default (spring.data.r2dbc.repositories.enabled=true), so that the @EnableR2dbcRepositories is not necessary.


