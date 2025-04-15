package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.SysPer;
import com.example.domain.TableDataInfo;
import com.example.domain.req.sysPer.SysPerAddReq;
import com.example.domain.req.sysPer.SysPerQueryPageReq;
import com.example.domain.req.sysPer.SysPerUpdateReq;
import com.example.domain.vo.SysPerVo;

/**
* @author QJJ
* @description 针对表【sys_per(缺陷表)】的数据库操作Service
* @createDate 2025-03-31 00:18:56
*/
public interface SysPerService extends IService<SysPer> {

    TableDataInfo<SysPer> queryPerListPage(SysPerQueryPageReq sysPerQueryPageReq);
    void addPer(SysPerAddReq sysPerAddReq);
    void updatePer(SysPerUpdateReq sysPerUpdateReq);
    void deletePer(Long perId);
    SysPerVo queryByPerId(Long perId);
    void queryPerList();

}
