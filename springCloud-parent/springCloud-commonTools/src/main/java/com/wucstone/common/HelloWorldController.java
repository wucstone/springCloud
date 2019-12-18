package com.wucstone.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    private HandlerContext handlerContext;

    @GetMapping("hello")
    public String hello(){
        AbstractHandler handler = handlerContext.getInstance("1");
        return handler.execHandler("1");
    }




}
