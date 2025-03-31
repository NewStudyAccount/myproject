package com.example.controller;


import com.example.domain.ResponseModel;
import com.example.domain.vo.LoginUserVo;
import com.example.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "管理员")
@RestController
@RequestMapping("/project")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "登录接口")
    @PostMapping("/admin/login")
    public ResponseModel login(@RequestBody LoginUserVo loginUserVo){

        ResponseModel login = loginService.login(loginUserVo);
        return login;
    }

}
