package com.wucstone.api.order.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface IOrderShardingService {
	
	@PostMapping("/saveOrder")
	public String saveOrder(String name);

	@GetMapping("queryOrderById")
	public String queryOrderById(String id);

}
