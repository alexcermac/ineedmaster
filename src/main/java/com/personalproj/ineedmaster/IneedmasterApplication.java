package com.personalproj.ineedmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class IneedmasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(IneedmasterApplication.class, args);
	}

}
