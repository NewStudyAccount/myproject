package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseModel<T>{

    private int code;

    private String msg;

    private T data;


    public static<T> ResponseModel<T> success(String msg,T data) {
        return new ResponseModel(200, msg, data);
    }

    public static<T>  ResponseModel<T> authSuccess(T data) {
        return new ResponseModel(200, "authentication success", data);
    }


    public static<T> ResponseModel<T> authFailure(T data) {
        return new ResponseModel(401, "认证失败401", data);
    }

    public static<T> ResponseModel<T> accessDenied(T data) {
        return new ResponseModel(403, "授权失败403", data);
    }

    public static<T> ResponseModel<T> logoutSuccess(T data) {
        return new ResponseModel(200, "logoutSuccess success", data);
    }



}
