package com.sprint3r.deans4j;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Resource
	OrderService orderService;
	
	
	
	@PostMapping(value="/orderProduct", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponesBean save(@RequestBody OrderProduct orderProduct) {
		System.out.println("save");
		ResponesBean resutl = new ResponesBean();
		orderService.save(orderProduct,resutl);
		
		return resutl;
	}
	
}
