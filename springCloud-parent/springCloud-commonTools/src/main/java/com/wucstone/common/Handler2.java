package com.wucstone.common;

import org.springframework.stereotype.Component;

@Component
@HandlerType("22222")
public class Handler2 extends AbstractHandler {
    @Override
    public String handler(String params) {
        return "22222";
    }
}
