package com.adminappproject.trajan.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.adminappproject.trajan" })
public class MainInstanceInitiator {
	public static void main(String[] args) {
        SpringApplication.run(MainInstanceInitiator.class, args);
    }
}
