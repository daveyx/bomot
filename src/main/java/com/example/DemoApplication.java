package com.example;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.mongo.repo.CustomerRepository;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	@Inject
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//        new SpringApplicationBuilder(DemoApplication.class)
//        .web(true)
//        .run(args);
	}
}
