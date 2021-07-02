package com.dong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MybatisPlusTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusTestApplication.class, args);
	}

}
