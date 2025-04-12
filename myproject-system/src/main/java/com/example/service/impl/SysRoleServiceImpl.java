package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysRole;
import com.example.domain.req.SysRoleAddReq;
import com.example.domain.req.SysRoleUpdateReq;
import com.example.domain.vo.SysRoleVo;
import com.example.mapper.SysRoleMapper;
import com.example.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
* @author QJJ
* @description 针对表【sys_role(角色表)】的数据库操作Service实现
* @createDate 2025-03-31 00:18:56
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService {

    @Override
    public SysRoleVo queryByRoleId(Long roleId) {
        SysRole sysRole = this.lambdaQuery().eq(SysRole::getRoleId, roleId).one();
        SysRoleVo sysRoleVo = new SysRoleVo();
        BeanUtils.copyProperties(sysRole,sysRoleVo);
        return sysRoleVo;
    }

    @Override
    public void addRole(SysRoleAddReq sysRoleAddReq) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleAddReq, sysRole);
        return this.baseMapper.insert(sysRole);
    }

    @Override
    public void updateRole(SysRoleUpdateReq sysRoleUpdateReq) {
        this.lambdaUpdate()
                .set(!StringUtils.isEmpty(sysRoleUpdateReq.getRoleName()),SysRole::getRoleName, sysRoleUpdateReq.getRoleName())  // 设置待更新字段值
                .eq(SysRole::getRoleId, sysRoleUpdateReq.getRoleId())       // WHERE 条件：role_id = 参数值
                .update();                                         // 执行更新
    }

    @Override
    public int deleteRole(Long roleId) {
        return 0;
    }
}




