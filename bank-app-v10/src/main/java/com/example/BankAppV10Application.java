package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages= {"com.example"})
//or
@SpringBootApplication
public class BankAppV10Application {

	public static void main(String[] args) {
		SpringApplication.run(BankAppV10Application.class, args);
	}
}
