package com.example.domain.vo;


import com.example.domain.SysUser;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserInfoVo {

    SysUser sysUser;

    List<String> permissionCodes;
}
