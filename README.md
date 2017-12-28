[![Build Status](http://54.82.248.248:8080/job/01_Build_App/badge/icon)](http://54.82.248.248:8080/job/01_Build_App/)

# IntuitCodingChallange
	
	IntuitCodingChallange is a java, springboot application which saves the number of users who liked/ disliked a movie in Spring Cache and displays the same on UI.

	Also has a reset link to reset all the users.

### Pre-requisite
- Supports JDK 1.8 and Spring and supports development in java, build system is maven
- Suggested to used IntelliJ IDEA or Eclipse to compile and execute


## Technologies/ Tools/ Services Used:
- Java 8
- Maven
- SpringBoot
- Restful Webservices
- Spring Cache
- JQuery
- HTML
- Apache Logging


## Steps to Build the Application
### Jenkins
1. Login to Jenkins @http://54.82.248.248:8080/ with credentials admin/ admin
2. Goto job **01_Build_App**, and enter desired git branch to build it from
3. Click on Build.
4. Once build is done, the java artifact is archived.
5. Once build is successful, it has a downstream build job, **02_Stage_Artifact_to_S3** which will upload the artifact to 		S3 bucket.

### Local Machine
1. mvn clean install
2. Run the application, by adding the main class to Run Configuration.
3. If you want to run the application from command line, run the below command.
	mvn spring-boot:run
4. GoTo your browser and hit http://http://localhost:8090/voting/ for application or,
5. GoTo http://localhost:8090/voting/ping for ping page.
