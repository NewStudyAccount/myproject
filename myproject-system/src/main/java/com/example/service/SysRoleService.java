package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.SysRole;

/**
* @author QJJ
* @description 针对表【sys_role(角色表)】的数据库操作Service
* @createDate 2025-03-31 00:18:56
*/
public interface SysRoleService extends IService<SysRole> {

    int addRole(SysRole sysRole);

    void updateRole(SysRole sysRole);

    int deleteRole(Long roleId);



}
