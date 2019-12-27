package com.wucstone.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wucstone.api.order.service.IOrderShardingService;
import com.wucstone.order.domain.OrderDO;
import com.wucstone.order.mapper.data.MyOrderMapper;
import com.wucstone.order.mapper.sharding.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderShardingServiceImpl implements IOrderShardingService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private MyOrderMapper myOrderMapper;

	@Override
	@GetMapping("/saveOrder")
	public String saveOrder(String name) {
//		for(int i=0 ;i < 100 ; i++ ){
//			OrderDO orderDO = new OrderDO();
//			orderDO.setId(new Long(i));
//			orderDO.setOrderNo("sharding_" + i);
//
//			orderMapper.saveOrder(orderDO);
//
//		}
//
//
//		OrderDO orderDO = new OrderDO();
//		orderDO.setId(new Long(1000));
//		orderDO.setOrderNo("sharding_" + 1000);
//		myOrderMapper.saveOrder(orderDO);

		return JSONObject.toJSONString(orderMapper.selectOrders());
	}

	@Override
	public String queryOrderById(String id) {
		return null;
	}
}
