package com.adminappproject.trajan.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.adminappproject.trajan"})
@EntityScan("com.adminappproject.trajan.model")
@EnableJpaRepositories("com.adminappproject.trajan.repo")
public class MainInstanceInitiator {
	public static void main(String[] args) {
        SpringApplication.run(MainInstanceInitiator.class, args);
    }
}
