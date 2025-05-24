package com.example.domain.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 不用于注册，需要改掉
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {



    /**
     * 用户名
     */
    @JsonProperty(value = "USER_NAME")
    private String userName;

    /**
     * 用户密码
     */
    @JsonProperty(value = "PASSWORD")
    private String password;

    /**
     * 性别
     */
    @JsonProperty(value = "SEX")
    private String sex;

}
