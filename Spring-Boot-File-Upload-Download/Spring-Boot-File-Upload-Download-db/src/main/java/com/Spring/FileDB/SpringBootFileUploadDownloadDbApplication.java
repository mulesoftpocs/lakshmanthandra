package com.Spring.FileDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SpringBootFileUploadDownloadDbApplication {
	
	private static final Logger logger= LoggerFactory.getLogger(SpringBootFileUploadDownloadDbApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileUploadDownloadDbApplication.class, args);
		
		logger.info("this is for info the message");
		logger.error("this is for error the message");
		logger.warn("this is for warn the message");
	}

	 @Bean
	   public Docket addSwagger() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.Spring.FileDB")).build();
	   }
	
}
