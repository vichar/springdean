package com.sprint3r.deans4j;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Resource
	OrderService orderService;
	
	@PostMapping("/")
	public ResponesBean save(@RequestBody OrderProduct orderProduct) {
		
		ResponesBean resutl = new ResponesBean();
		orderService.save(orderProduct,resutl);
		
		return resutl;
	}
	
}
