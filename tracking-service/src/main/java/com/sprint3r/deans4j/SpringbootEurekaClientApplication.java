package com.sprint3r.deans4j;

import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class SpringbootEurekaClientApplication {
	
	@Autowired
	TrackingRepository repo;
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@PostMapping("/updateTrackingNumber")
	String updateTrackingNumber(Long orderId, String tackingNumber) {
		
		Optional<Tracking> t = repo.findByOrderId(orderId);
		Tracking tracking;
		if (t.empty() != null) {
			tracking = new Tracking(tackingNumber, "Packing", orderId);
		} else {
			tracking = t.get();
		}
		tracking.setTackingNumber(tackingNumber);
		repo.save(tracking);
		return "success";
	}
	
	@PostMapping("/updateTrackingStatus")
	String updateTrackingStatus(Long orderId, String status) {
		
		Optional<Tracking> t = repo.findByOrderId(orderId);
		Tracking tracking = t.get();
		tracking.setStatus(status);
		repo.save(tracking);
		return "success";
	}
	
	@GetMapping("/getTrackingStatusByOrderId/{orderId}")
	Iterable<Tracking> genTrackingNoByOrderId(@PathVariable("orderId") Long orderId) {
		return repo.findAllByOrderId(orderId);
	}

	@Bean
	public InitializingBean seedDatabase(TrackingRepository repository) {
		System.out.println("initial DB");
		return () -> {
			repository.save(new Tracking("EMS123456777", "Packing", 1L));
			repository.save(new Tracking("KEERY9999", "Packing", 2L));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEurekaClientApplication.class, args);
	}
}
