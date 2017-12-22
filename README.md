[![Build Status](http://54.82.248.248:8080/job/01_Build_App/badge/icon)](http://54.82.248.248:8080/job/01_Build_App/)

# IntuitCodingChallange
	
	IntuitCodingChallange is a java, springboot application which saves the number of users who liked/ disliked a movie in Spring Cache and displays the same on UI.

	Also has a reset link to reset all the users.


## Technologies/ Tools Used:

- Java 8
- Maven
- SpringBoot
- Restful Webservices
- Spring Cache
- JQuery
- HTML
- Apache Logging


## Steps to Build the Application

1. Login to Jenkins @http://54.82.248.248:8080/ with  credentials admin/ admin
2. Goto job **01_Build_App**, and enter desired git branch to build it from
3. Click on Build.
4. Once build is done, the java artifact is archived.
5. Once build is successful, it has a downstream build job, **02_Stage_Artifact_to_S3** which will upload the artifact to 		S3 bucket.

