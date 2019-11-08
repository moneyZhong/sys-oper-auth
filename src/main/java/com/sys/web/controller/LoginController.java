package com.sys.web.controller;

import com.netflix.discovery.converters.Auto;
import com.sys.comm.response.CommonReturnType;
import com.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController extends  BaseController{
    @Autowired
    private UserService userService;

//    public CommonReturnType auth(@RequestBody ){
//
//    }
}
