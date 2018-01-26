package com.myTest.IntuitCodingChallenge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		
//		To be used to show all the default Spring doc
		/*
		 * return new Docket(DocumentationType.SWAGGER_2) .select()
		 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any()) .build();
		 */

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.myTest.IntuitCodingChallenge"))
				.paths(PathSelectors.any())
//				.paths(PathSelectors.regex("/votingservice.*"))
				.build();

	}
}
