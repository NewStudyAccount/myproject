package com.example.domain.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class SysRoleAddReq {

    /**
     * 角色名
     */
    @TableField(value = "role_name")
    private String roleName;

}