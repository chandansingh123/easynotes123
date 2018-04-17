package com.chandan.easynotes123;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Easynotes123Application {

	public static void main(String[] args) {
		SpringApplication.run(Easynotes123Application.class, args);
	}
}


