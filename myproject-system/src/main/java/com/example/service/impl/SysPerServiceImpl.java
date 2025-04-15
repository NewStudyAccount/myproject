package com.example.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysPer;
import com.example.domain.TableDataInfo;
import com.example.domain.req.sysPer.SysPerAddReq;
import com.example.domain.req.sysPer.SysPerQueryPageReq;
import com.example.domain.req.sysPer.SysPerUpdateReq;
import com.example.domain.vo.SysPerVo;
import com.example.mapper.SysPerMapper;
import com.example.service.SysPerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author QJJ
* @description 针对表【sys_per(缺陷表)】的数据库操作Service实现
* @createDate 2025-03-31 00:18:56
*/
@Service
public class SysPerServiceImpl extends ServiceImpl<SysPerMapper, SysPer>
    implements SysPerService {

    @Autowired
    private SysPerMapper sysPerMapper;

    @Override
    public TableDataInfo<SysPer> queryPerListPage(SysPerQueryPageReq sysPerQueryPageReq) {
        Page<SysPer> sysPerPage = sysPerMapper.selectPage(sysPerQueryPageReq.getPageQuery().build(), null);
        TableDataInfo<SysPer> build = TableDataInfo.build(sysPerPage);
        return build;

    }

    @Override
    public void addPer(SysPerAddReq sysPerAddReq) {
        SysPer sysPer = new SysPer();
        BeanUtils.copyProperties(sysPerAddReq,sysPer);
        this.baseMapper.insert(sysPer);

    }

    @Override
    public void updatePer(SysPerUpdateReq sysPerUpdateReq) {
        boolean update = this.lambdaUpdate()
                .eq(SysPer::getPerId, sysPerUpdateReq.getPerId())
                .set(SysPer::getPerCode, sysPerUpdateReq.getPerCode())
                .update();

    }

    @Override
    public void deletePer(Long perId) {
        //后续再做逻辑删除

    }

    @Override
    public SysPerVo queryByPerId(Long perId) {
        SysPer sysPer = this.lambdaQuery().eq(SysPer::getPerId, perId).one();
        SysPerVo sysPerVo = new SysPerVo();
        BeanUtils.copyProperties(sysPer,sysPerVo);
        return sysPerVo;
    }

    @Override
    public void queryPerList() {

    }
}




