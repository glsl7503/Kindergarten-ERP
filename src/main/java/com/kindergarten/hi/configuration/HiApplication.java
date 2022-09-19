package com.kindergarten.hi.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.kindergarten.hi")
public class HiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiApplication.class, args);
	}

}
