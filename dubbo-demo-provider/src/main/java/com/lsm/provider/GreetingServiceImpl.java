package com.lsm.provider;

import com.lsm.api.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
