package com.ignite.project.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
  BookApplication

 * This is the main entry point of the Spring Boot application.
 * It bootstraps the backend API for fetching and filtering books.
 *
 * Author: Siddharth Kardile
 */
@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

}
