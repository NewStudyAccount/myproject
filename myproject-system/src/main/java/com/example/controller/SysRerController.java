package com.example.controller;


import com.example.domain.Response;
import com.example.domain.SysPer;
import com.example.domain.TableDataInfo;
import com.example.domain.req.sysPer.SysPerAddReq;
import com.example.domain.req.sysPer.SysPerQueryPageReq;
import com.example.domain.req.sysPer.SysPerUpdateReq;
import com.example.domain.vo.SysPerVo;
import com.example.service.SysPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project/per")
public class SysRerController {


    @Autowired
    private SysPerService sysPerService;



    @PostMapping("/queryPage")
    public TableDataInfo<SysPer> queryPerListPage(@RequestBody SysPerQueryPageReq sysPerQueryPageReq) {
        TableDataInfo<SysPer> sysPerTableDataInfo = sysPerService.queryPerListPage(sysPerQueryPageReq);
        return sysPerTableDataInfo;
    }


    @PostMapping("/add")
    public Response<Object> insertPer(@RequestBody @Validated SysPerAddReq sysPerAddReq) {
        sysPerService.addPer(sysPerAddReq);
        return Response.success("新增成功");
    }

    @PostMapping("/update")
    public Response<Object> updatePer(@RequestBody @Validated SysPerUpdateReq sysPerUpdateReq) {
        sysPerService.updatePer(sysPerUpdateReq);
        return Response.success("更新成功");
    }


    @GetMapping("/query/{perId}")
    public Response<SysPerVo> queryRoleListById(@PathVariable("perId")Long perId) {
        SysPerVo sysPerVo = sysPerService.queryByPerId(perId);
        return Response.success(sysPerVo);
    }


    public Response<Object> queryPerList() {
        return Response.success("查询成功");
    }
}
