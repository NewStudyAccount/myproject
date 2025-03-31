package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色权限表
 * @TableName sys_role_per
 */
@TableName(value ="sys_role_per")
@Data
public class SysRolePer implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    /**
     * 
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 
     */
    @TableField(value = "per_id")
    private Long perId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}