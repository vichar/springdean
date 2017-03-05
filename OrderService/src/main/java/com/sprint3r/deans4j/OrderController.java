package com.sprint3r.deans4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@PostMapping("/")
	public String save() {
		return "service unavliable";
	}
	
}
