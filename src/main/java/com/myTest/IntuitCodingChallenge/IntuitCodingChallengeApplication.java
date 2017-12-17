package com.myTest.IntuitCodingChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication (scanBasePackages = { "com.myTest.service.CacheService", "com.myTest.common.MovieDetails"})
//        (scanBasePackages = { "com.myTest.service.CacheService"})
//@ComponentScan ({"com.myTest.common.MovieDetails", "com.myTest.service.CacheService"})
public class IntuitCodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntuitCodingChallengeApplication.class, args);
	}
}
