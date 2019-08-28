package com.lsm.dubbo.boot.controller;

import com.lsm.api.GreetingService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
    private static final Logger log= LoggerFactory.getLogger(HomeController.class);

//    @Reference(version = "${greeting.service.version}")
//    private GreetingService greetingService;

    @RequestMapping("hello")
    public String hello(String name) {
//        String result = greetingService.sayHello(name);
//        log.info(result);
//        return result;
        return "xxx";
    }
}
