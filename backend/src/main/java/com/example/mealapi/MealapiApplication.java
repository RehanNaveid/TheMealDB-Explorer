package com.example.mealapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MealapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealapiApplication.class, args);
	}

}
