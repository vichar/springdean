package com.sprint3r.deans4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class OrderEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderEurekaClientApplication.class, args);
	}
}
