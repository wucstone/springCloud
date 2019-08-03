package com.wucstone.common;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HandlerContext implements ApplicationContextAware {

    private Map<String,Class> handlerMap;
    private ApplicationContext applicationContext;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type){
        Class claz = handlerMap.get(type);
        if(claz == null){
            throw new IllegalArgumentException("not fount handler for type:"+type);
        }
        return (AbstractHandler)applicationContext.getBean(claz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
