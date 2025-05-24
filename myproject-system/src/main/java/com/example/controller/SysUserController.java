package com.example.controller;


import com.example.domain.Response;
import com.example.domain.vo.UserInfoVo;
import com.example.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("/queryUserInfo")
    public Response<?> queryUserInfo(Long userId){
        List<UserInfoVo> userInfoVos = sysUserService.queryUserInfo(userId);
        return Response.success(userInfoVos);
    }


}
