package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysUserRole;
import com.example.domain.req.sysUserRole.SysUserRoleAddReq;
import com.example.mapper.SysUserRoleMapper;
import com.example.service.SysUserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author QJJ
* @description 针对表【sys_user_role(用户角色关联表)】的数据库操作Service实现
* @createDate 2025-03-31 00:18:56
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;



    @Override
    public void queryUserRolePage() {

    }

    @Override
    public void queryUserRoleList() {

    }

    @Override
    public void addUserRole(SysUserRoleAddReq sysUserRoleAddReq) {
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(sysUserRoleAddReq,sysUserRole);
        baseMapper.insert(sysUserRole);

    }

    @Override
    public void deleteUserRole(Long id) {

    }
}




