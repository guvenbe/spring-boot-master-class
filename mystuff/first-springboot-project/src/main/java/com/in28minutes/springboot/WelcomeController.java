package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.in28minutes")
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @RequestMapping("/welcome")
    public String welcome(){
        return service.retrieveWelcomeMessage();
    }
}


