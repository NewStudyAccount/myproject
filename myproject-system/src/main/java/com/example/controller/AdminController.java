package com.example.controller;

import com.example.domain.Response;
import com.example.domain.vo.UserVo;
import com.example.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project/admin")
public class AdminController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/register")
    public Response registerUser(@RequestBody UserVo userVo){

        int register = sysUserService.register(userVo);
        return Response.success("注册成功",register);
    }


    @PostMapping("/hello")
    public Response hello(){


        return Response.success("success","hello");
    }


}
