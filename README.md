## Using MySQL in Spring Boot via Spring Data JPA and Hibernate

### Build and run

#### Configurations

Open the `application.properties` file and set your own configurations.

#### Prerequisites

- Java 7
- Gradle 2.8

#### JAR

    $ ./gradlew build


#### From terminal

Go on the project's root folder, then type:

    $ ./gradlew bootRun

#### Run from production environment

Run the projects with production configuration

    $ java -jar build/libs/learning-spring-boot-0.1.0.jar --spring.config.location=deploy/application-prod.properties

### Usage

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `/create?email=[email]&name=[name]`: create a new user with an auto-generated id and email and name as passed values.
    * `/delete?id=[id]`: delete the user with the passed id.
    * `/get-by-email?email=[email]`: retrieve the id for the user with the passed email address.
    * `/update?id=[id]&email=[email]&name=[name]`: update the email and the name for the user indentified by the passed id.