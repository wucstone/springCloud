package com.wucstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="com.wucstone.order.api.feignClient")
@EnableHystrix
@EnableTransactionManagement
public class AppOrder {
	
	public static void main(String[] args) {
		SpringApplication.run(AppOrder.class, args);
	}
}
