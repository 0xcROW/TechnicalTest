The whole project was writen in IntelliJ Idea Ultimate IDE.

OpenJDK 22.0.2.

Simple API Rest made in Java SE 17 using Spring Boot 3.3.3 and Maven.

The database used is H2, with JDBC and JPA - despite the H2 is a well-known in-memory database, in this project I'm using it with persistence to keep the objects inside the table.
Once the objects are loaded when the main application starts, is more easier to test the API with the endpoint.

The API documentation and the endpoint tests was made in Postman, there are a configuration JSON in this repository, with all the routes and the tests ready to use.

Don't forget to change the JDBC url to jdbc:h2:file:~/companyxdb if it contains another address when accessing /h2-console.

The address when started is http://localhost8080.
