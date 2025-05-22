package com.example.kfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KfcApplication {

	public static void main(String[] args) {
		SpringApplication.run(KfcApplication.class, args);
	}

}
