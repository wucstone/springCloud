package com.wucstone.common;

import java.util.logging.Logger;

public abstract class AbstractHandler {

    public abstract String handler(String params);

    public String execHandler(String params){
        return handler(params);
    }
}
