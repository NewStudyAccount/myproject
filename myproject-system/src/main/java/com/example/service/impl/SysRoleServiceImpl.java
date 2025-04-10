package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysRole;
import com.example.mapper.SysRoleMapper;
import com.example.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
* @author QJJ
* @description 针对表【sys_role(角色表)】的数据库操作Service实现
* @createDate 2025-03-31 00:18:56
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService {

    @Override
    public int addRole(SysRole sysRole) {
        return this.baseMapper.insert(sysRole);
    }

    @Override
    public void updateRole(SysRole sysRole) {
        this.lambdaUpdate()
                .set(SysRole::getRoleName, sysRole.getRoleName())  // 设置待更新字段值
                .eq(SysRole::getRoleId, sysRole.getRoleId())       // WHERE 条件：role_id = 参数值
                .update();                                         // 执行更新
    }

    @Override
    public int deleteRole(Long roleId) {
        return 0;
    }
}




