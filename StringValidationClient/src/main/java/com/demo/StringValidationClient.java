package com.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.services.StringValidator;

@SpringBootApplication
public class StringValidationClient {

	static String string;
	
	@Autowired
	StringValidator stringValidationService;
	
	static boolean stringValidationResult;
	
	public static void main(String[] args) {
		
		string=args[0];
		
		SpringApplication.run(StringValidationClient.class, args);

	
		if(stringValidationResult) {
			System.out.println("string passes the given conditions");
		} else {
			System.out.println("\nstring does not pass the given conditions");
		}

	}
	
	@PostConstruct
	public void init() {
		stringValidationResult = stringValidationService.validateString(string);
	}
	
}
