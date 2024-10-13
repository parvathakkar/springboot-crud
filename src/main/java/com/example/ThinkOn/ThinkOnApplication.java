package com.example.ThinkOn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThinkOnApplication {
	//FLOW:
	// CONTROLLER INVOKES SERVICE
	// SERVICE INVOKES THE JPA REPO
	// THE REPO HAS ALL OF THE METHODS WE CAN USE FOR OUR PURPOSES
	public static void main(String[] args) {
		SpringApplication.run(ThinkOnApplication.class, args);
	}
}
