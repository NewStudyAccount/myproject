package com.example.controller;

import com.example.domain.ResponseModel;
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
    public ResponseModel registerUser(@RequestBody UserVo userVo){

        int register = sysUserService.register(userVo);
        return ResponseModel.success("注册成功",register);
    }


    @PostMapping("/hello")
    public ResponseModel hello(){


        return ResponseModel.success("success","hello");
    }


}
