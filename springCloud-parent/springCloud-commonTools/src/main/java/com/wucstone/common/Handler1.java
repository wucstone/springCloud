package com.wucstone.common;

import org.springframework.stereotype.Component;

@Component
@HandlerType("11111")
public class Handler1 extends AbstractHandler {
    @Override
    public String handler(String params) {
        return "111111";
    }
}
