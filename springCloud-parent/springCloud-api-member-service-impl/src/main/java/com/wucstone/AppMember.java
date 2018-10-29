package com.wucstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="com.wucstone.service")
@ComponentScan("com.wucstone")
public class AppMember {
	
	
	public static void main(String[] args) {
		SpringApplication.run(AppMember.class, args);
	}

}
