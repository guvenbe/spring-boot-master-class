package com.in28minutes.springboot.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LoginService {
    public boolean validateUser(String userid, String password){
        //in28Minutes, dummy
        return userid.equalsIgnoreCase("in28minutes") && password.equalsIgnoreCase("dummy");
    }
}
