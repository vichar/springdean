package com.sprint3r.deans4j;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Resource
	OrderRepository orderRepository;
	
	@Resource
	CustomerRespoitory customerRespoitory;
	
	public void save(OrderProduct orderProduct,ResponesBean result) {
		try {
			customerRespoitory.save(new Customer((orderProduct.getFristName()+orderProduct.getLastName()),orderProduct.getAddress()));
			orderRepository.save(new Orders(orderProduct.getName(), orderProduct.getPrice(), orderProduct.getDesc()));
			result.setCode("000");
			result.setDesc("save success");
		}catch (Exception e) {
			result.setCode("999");
			result.setDesc("save fail when : "+e.getMessage());
		}
	}
}
