package com.example.service;


import com.example.domain.ResponseModel;
import com.example.domain.vo.LoginUserVo;

public interface LoginService {

    public ResponseModel login(LoginUserVo loginUserVo);
}
