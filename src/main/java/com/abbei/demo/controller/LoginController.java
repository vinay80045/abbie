package com.abbei.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abbei.demo.entity.Users;
import com.abbei.demo.model.UserLoginRequestModel;
import com.abbei.demo.service.LoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
    @GetMapping("/login")
    public String welcome() {
        return "Welcome to abbie !!";
    }
	
    @PostMapping("/fetchUserDetails")
    public Map<String, Object> login(@RequestBody UserLoginRequestModel userReqestModel) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("response", loginService.login(userReqestModel.getUserName()).getBody());
		return map;
    }
    @PostMapping("/sunmitregistration")
    public Map<String, Object> registerUser(@RequestBody Users usr) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("response", loginService.registerUser(usr).getBody());
		return map;
    }

}
