# MIDPS Lab #3

This repository contains the work done for third MIDPS Laboratory described [here](https://github.com/BestMujik/MIDPS-labs/blob/midps_fr/MIDPS_LAB%233.md). The project reperesents a Java REST API as backend built using Spring framework and a frontend built with AngularJS.

## Links

* Repository: https://github.com/emirovschi/MIDPS-3
* Documentation: https://github.com/emirovschi/MIDPS-3/blob/master/Documentation/Lab_template.pdf
* Release: http://midps3.herokuapp.com/
* Used IDE: IntelliJ
* Programming language: Java, JavaScript
* Used technologies: Maven, Spring Framework, Spring Boot, Spring Data, AngularJS, Angular Material

## Taks
1. Implementation of a website.
2. The website should use a databas
3. The website should contain AJAX requets
4. Implementation of XHR or JSON response. Some of the information should be dynamically loaded on the page.

## Configuration
In order to use different database sources the project requires specific configuration. The following environment variabiles are mandatory for the project to work:
* `JDBC_DATABASE_URL` - Database URL
* `JDBC_DATABASE_USERNAME` - Database user
* `JDBC_DATABASE_PASSWORD` - Dataase password
* `JDBC_DATABASE_DRIVER` - Database dirver. This field depends on the type of database used.
* `JDBC_DATABASE_DIALECT` - Database dialect. This field depends on the type of database used which should be the same used for driver property.

Example:
```
JDBC_DATABASE_URL=jdbc:h2:./database;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
JDBC_DATABASE_USERNAME=sa
JDBC_DATABASE_PASSWORD=
JDBC_DATABASE_DRIVER=org.h2.Driver
JDBC_DATABASE_DIALECT=org.hibernate.dialect.H2Dialect
```