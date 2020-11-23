package com.wucstone.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wucstone.entity.UserEntity;
import com.wucstone.service.IMemberService;

@RestController
public class MemberServiceImpl implements IMemberService{

	@RequestMapping("/getMember")
	@Override
	public UserEntity getMember(String name) {
		
		UserEntity entity = new UserEntity();
		entity.setName(name);
		entity.setAge(29);
		System.out.println(JSONObject.toJSONString(entity));
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return entity;
	}

}
