package com.myTest.IntuitCodingChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/*
* Main class
*
* Created by NUS889 on 12/16/2017.
* */
@EnableCaching
@SpringBootApplication (scanBasePackages = { "com.myTest"})
public class IntuitCodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntuitCodingChallengeApplication.class, args);
	}

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            container.addErrorPages(error404Page);
        });
    }

}
