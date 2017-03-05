package com.sprint3r.deans4j;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class SpringbootEurekaClientApplication {
	
	@Autowired
	TrackingRepository repo;
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@GetMapping("/getTrackingStatusByOrderId")
	Iterable<Tracking> genTrackingNoByOrderId() {
		Iterable<Tracking> list = jdbcTemplate.query("select * from Tracking t WHERE t.orderId = ?", new Object[]{1},
    			
    			(rs, rowNum) ->
		        
		    	new Tracking(
		                rs.getLong("id"),
		                rs.getString("tackingNumber"),
		                rs.getDate("sentDate"),
		                rs.getLong("orderId"))
        ); 
    	
        return list;
	}

	@Bean
	public InitializingBean seedDatabase(TrackingRepository repository) {
		System.out.println("initial DB");
		return () -> {
			repository.save(new Tracking("EMS123456777", new Date(), 1L));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEurekaClientApplication.class, args);
	}
}
