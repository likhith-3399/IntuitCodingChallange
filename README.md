[![Build Status](http://54.82.248.248:8080/job/01_Build_App/badge/icon)](http://54.82.248.248:8080/job/01_Build_App/)

# IntuitCodingChallange
	
	IntuitCodingChallange is a java, springboot application which saves the number of users who liked/ disliked a movie in Spring Cache and displays the same on UI.

	Also has a reset link to reset all the users.

### Pre-requisite
- Supports JDK 1.8 and Spring and supports development in java, build system is maven
- Suggested to used IntelliJ IDEA or Eclipse to compile and execute the application


## Technologies/ Tools/ Services Used:
- Java 8
- Maven
- SpringBoot
- Restful Webservices
- Spring Cache
- JQuery
- HTML
- Apache Logging
- Swagger 2.0

## Swagger 2.0 Documentation
*	Swagger Doc
>	URL: http://localhost:8080/votingservice/v2/api-docs

*	Swagger UI - Doc
>	URL: http://localhost:8080/votingservice/swagger-ui.html


## Steps to Build the Application

### Local Machine
1. mvn clean install
2. Run the application, by adding the main class to Run Configuration.
3. If you want to run the application from command line, run the below command.
	mvn spring-boot:run
4. GoTo your browser and hit http://http://localhost:8080/votingservice/ for application or,
5. GoTo http://localhost:8080/votingservice/ping for ping page.
