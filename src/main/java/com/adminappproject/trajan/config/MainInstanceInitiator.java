package com.adminappproject.trajan.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
@ComponentScan(basePackages = { "com.adminappproject.trajan.controller", "com.adminappproject.trajan.service",
		"com.adminappproject.trajan.validator", "com.adminappproject.trajan.config" })
@EnableJpaRepositories("com.adminappproject.trajan.repo")
@EntityScan("com.adminappproject.trajan.model")
@EnableJpaAuditing
public class MainInstanceInitiator extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainInstanceInitiator.class);
	}

	/*Hibernate Session*/
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("i18n/messages");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(MainInstanceInitiator.class, args);
	}
}
