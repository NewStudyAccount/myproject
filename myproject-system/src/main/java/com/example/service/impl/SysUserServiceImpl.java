package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysRolePer;
import com.example.domain.SysUser;
import com.example.domain.SysUserDto;
import com.example.domain.SysUserRole;
import com.example.domain.vo.UserVo;
import com.example.mapper.SysUserMapper;
import com.example.service.SecurityAdminService;
import com.example.service.SysRolePerService;
import com.example.service.SysUserRoleService;
import com.example.service.SysUserService;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author QJJ
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2025-03-31 00:18:56
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService, SecurityAdminService {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    @Autowired
    private SysUserMapper sysUserMapper;


    @Autowired
    private SysUserRoleService sysUserRoleService;


    @Autowired
    private SysRolePerService sysRolePerService;

    /**
     * security使用查询用户信息
     * @param userName
     * @return
     */
    @Override
    public SysUserDto queryByUserName(String userName) {

        SysUserDto sysUserDto = new SysUserDto();

        SysUser one = this.lambdaQuery().eq(SysUser::getUserName, userName).one();
        BeanUtils.copyProperties(one,sysUserDto);

        return sysUserDto;
    }

    /**
     * security查询用户的权限
     * @param userId
     * @return
     */
    @Override
    public List<String> getUserPermission(Long userId) {


        List<SysUserRole> sysUserRoles = sysUserRoleService.queryUserRoleList(userId);
        for (SysUserRole sysUserRole : sysUserRoles) {
            List<SysRolePer> sysRolePers = sysRolePerService.queryRolePerList(sysUserRole.getRoleId());
            sysRolePers.get(0).getPerId();
            Set<Long> collect = sysRolePers.stream().map(SysRolePer::getPerId).collect(Collectors.toSet());

        }


        return List.of();
    }

    @Override
    public int register(UserVo userVo) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userVo.getUserName());
        sysUser.setUserPwd(new BCryptPasswordEncoder().encode(userVo.getPassword()));
        sysUser.setUserSex(userVo.getSex());

        return sysUserMapper.insert(sysUser);
    }
}




