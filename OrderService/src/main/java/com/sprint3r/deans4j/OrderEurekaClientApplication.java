package com.sprint3r.deans4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class OrderEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderEurekaClientApplication.class, args);
	}
}
