package com.application.complaintbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.application.complaintbox"})
public class ComplaintBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintBoxApplication.class, args);
	}
}
