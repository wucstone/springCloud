package com.wucstone.order.service.impl;

import com.wucstone.api.order.entity.CenterOrderDO;
import com.wucstone.order.mapper.data.OrderMapper;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wucstone.api.order.service.IOrderService;
import com.wucstone.entity.UserEntity;
import com.wucstone.order.api.feignClient.Order2MemberFeignClient;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderServiceImpl implements IOrderService{
	
	@Resource
	private Order2MemberFeignClient order2MemberFeignClient;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private TransactionTemplate transactionTemplate;



	//未解决服务雪崩效应
	@Override
	@GetMapping("/getMemberFromOrderService")
	public String getMemberFromOrderService(String name) {
		
		UserEntity user = order2MemberFeignClient.getMember(name);
		return user.getName()+"--"+user.getAge()+"--"+Thread.currentThread().getName();
		
	}
	/**
	 * @HystrixCommand 通过服务熔断/服务降级/服务隔离的方法解决雪崩效应
	 * @param name
	 * @return
	 */
	@HystrixCommand(fallbackMethod="fallBackGetMemberFromOrderServiceHystrix")
	@RequestMapping("/getMemberFromOrderServiceHystrix")
	public String getMemberFromOrderServiceHystrix(String name){
		
		UserEntity user = order2MemberFeignClient.getMember(name);
		return user.getName()+"--"+user.getAge()+"--"+Thread.currentThread().getName();
	}

	@PostMapping("/saveOrder")
	public void saveOrder(@RequestParam("name") Integer cnt){

		System.out.println(transactionTemplate.getTransactionManager().getClass());

		ThreadPoolExecutor pool = new ThreadPoolExecutor(10,20,3000, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
		CountDownLatch latch = new CountDownLatch(cnt);
		for(int i = 0;i<cnt;i++){
			final Integer ii = i;
			pool.submit(new Runnable() {
				@Override
				public void run() {
//					CenterOrderDO orderDO = new CenterOrderDO();
//					orderDO.setName("name"+ii);
//					orderDO.setOrderNo(UUID.randomUUID().toString());
//					orderMapper.insert(orderDO);
//					latch.countDown();
					orderMapper.saveOrder();
				}
			});
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String fallBackGetMemberFromOrderServiceHystrix(String name){
		return "现在是服务降级"+"--"+name+"--"+Thread.currentThread().getName();
	}
}
