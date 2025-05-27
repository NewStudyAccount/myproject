package com.example.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.*;
import com.example.domain.req.sysUser.SysUserQueryPageReq;
import com.example.domain.vo.SysPerVo;
import com.example.domain.vo.UserInfoVo;
import com.example.domain.vo.UserVo;
import com.example.mapper.SysUserMapper;
import com.example.service.*;
import com.example.utils.SecurityFrameworkUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;
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
    private SysRoleMenuService sysRoleMenuService;


    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 【Security】使用查询用户信息
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
     * 【Security】查询用户的权限
     * @param userId
     * @return
     */
    @Override
    public List<String> getUserPermission(Long userId) {

//        //查询用户的所有角色 sys_user_role
//        List<SysUserRole> sysUserRoles = sysUserRoleService.queryUserRoleList(userId);
//
//        //多线程查出角色的所有权限信息
//        List<CompletableFuture<Set<String>>> futures = new ArrayList<>();
//        for (SysUserRole sysUserRole : sysUserRoles) {
//            CompletableFuture<Set<String>> future = CompletableFuture.supplyAsync(() -> {
//                return getPerCodeByRoleId(sysUserRole.getRoleId());
//            }, threadPoolTaskExecutor).exceptionally(ex->{
//                // 处理异常情况
//                log.error("获取权限编码失败",ex);
//                return Collections.emptySet();
//            });
//            futures.add(future);
//        }
//
//        // 等待所有任务完成
//        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
//
//
//        // 提交所有异步任务，并合并去重
//        CompletableFuture<List<String>> futureResult = allFutures.thenApply(v -> {
//            return futures.stream()
//                    .map(CompletableFuture::join)
//                    .flatMap(Set::stream)
//                    .distinct()
//                    .collect(Collectors.toList());
//        });
//
//        return futureResult.join(); // 同步返回最终结果（根据实际需求决定是否异步）


        Long loginUserId = SecurityFrameworkUtils.getLoginUserId();

        return sysMenuService.listPermissionCodesByUserId(userId);
    }

//    public Set<String> getPerCodeByRoleId(Long roleId) {
//
//        Set<String> perCodeSet = new HashSet<>();
//        //查角色-菜单表 role_menu
//        List<SysRoleMenu> sysRoleMenus = sysRoleMenuService.listRoleMenuByRoleId(roleId);
//
//        if (!CollectionUtils.isEmpty(sysRoleMenus)){
//            for (SysRoleMenu sysRoleMenu : sysRoleMenus) {
//                Long meunId = sysRoleMenu.getMeunId();
//                SysMenu sysMenu = sysMenuService.queryMenuByMenuId(meunId);
//                String perCode = sysMenu.getPerCode();
//                perCodeSet.add(perCode);
//            }
//        }
//        return perCodeSet;
//    }





    @Override
    public int register(UserVo userVo) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userVo.getUserName());
        sysUser.setUserPwd(new BCryptPasswordEncoder().encode(userVo.getPassword()));
        sysUser.setUserSex(userVo.getSex());

        return sysUserMapper.insert(sysUser);
    }


    //分页查询所有用户
    @Override
    public TableDataInfo<SysUser> queryUserListPage(SysUserQueryPageReq sysUserQueryPageReq) {

        //构建查询条件
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(sysUserQueryPageReq.getUserName()),SysUser::getUserName,sysUserQueryPageReq.getUserName());

        //分页查询
        Page<SysUser> sysUserPage = sysUserMapper.selectPage(sysUserQueryPageReq.getPageQuery().build(), queryWrapper);
        TableDataInfo<SysUser> build = TableDataInfo.build(sysUserPage);

        return build;
    }


    /**
     * 用户登录之后返回的用户信息
     * 用户信息
     * 权限信息
     * 等
     * @param userId
     */
    @Override
    public List<UserInfoVo> queryUserInfo(Long userId) {

        SysUser sysUser = sysUserMapper.selectById(userId);
        sysUser.setUserPwd("******");

        List<String> userPermission = getUserPermission(userId);





        UserInfoVo userInfoVo = UserInfoVo.builder()
                .sysUser(sysUser).permissionCodes(userPermission)
                .build();

        return Collections.singletonList(userInfoVo);

    }
}




