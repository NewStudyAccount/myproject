package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysRolePer;
import com.example.mapper.SysRolePerMapper;
import com.example.service.SysRolePerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author QJJ
* @description 针对表【sys_role_per(角色权限表)】的数据库操作Service实现
* @createDate 2025-03-31 00:18:56
*/
@Service
public class SysRolePerServiceImpl extends ServiceImpl<SysRolePerMapper, SysRolePer>
    implements SysRolePerService {

    @Autowired
    private SysRolePerMapper sysRolePerMapper;

    @Override
    public int addRolePer(Long roleId, Long perId) {
        SysRolePer sysRolePer = new SysRolePer(roleId,perId);
        return this.sysRolePerMapper.insert(sysRolePer);
    }

    @Override
    public List<SysRolePer> queryRolePerList(Long roleId) {
        return this.lambdaQuery().eq(SysRolePer::getRoleId,roleId).list();
    }
}




