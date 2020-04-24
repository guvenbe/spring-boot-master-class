package com.in28minutes.springboot.web;

import com.in28minutes.springboot.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String showWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){

        boolean isValidUser = service.validateUser(name, password);

        if(!isValidUser) {
            model.put("errorMessage", "Invalid Username or Password");
            return "login";
        }

        model.put("name",name);
        model.put("password",password);
        return "welcome";
    }

}
