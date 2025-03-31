package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysUser;
import com.example.domain.SysUserDto;
import com.example.domain.vo.UserVo;
import com.example.mapper.SysUserMapper;
import com.example.service.SecurityAdminService;
import com.example.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author QJJ
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2025-03-31 00:18:56
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService, SecurityAdminService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserDto queryByUserName(String userName) {

        SysUserDto sysUserDto = new SysUserDto();

        SysUser one = this.lambdaQuery().eq(SysUser::getUserName, userName).one();
        BeanUtils.copyProperties(one,sysUserDto);

        return sysUserDto;
    }

    @Override
    public List<String> getUserPermission(Long userId) {
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




