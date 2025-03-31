package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 缺陷表
 * @TableName sys_per
 */
@TableName(value ="sys_per")
@Data
public class SysPer implements Serializable {
    /**
     * 权限id
     */
    @TableId(type = IdType.AUTO, value = "per_id")
    private Long perId;

    /**
     * 权限code
     */
    @TableField(value = "per_code")
    private String perCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}