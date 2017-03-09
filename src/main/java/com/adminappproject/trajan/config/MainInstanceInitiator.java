package com.adminappproject.trajan.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@ComponentScan(basePackages = { "com.adminappproject.trajan.controller", "com.adminappproject.trajan.service",
		"com.adminappproject.trajan.validator" })
@EnableJpaRepositories("com.adminappproject.trajan.repo")
@EntityScan("com.adminappproject.trajan.model")
@EnableAutoConfiguration
public class MainInstanceInitiator {
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("i18n/messages");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
		return new WebSecurityConfig();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MainInstanceInitiator.class, args);
	}
}
