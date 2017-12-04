package com.example.t5;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
        new SpringApplicationBuilder(DemoApplication.class)
        .web(true)
        .run(args);
	}
}
