package com.example.controller;

import com.example.domain.Response;
import com.example.domain.TableDataInfo;
import com.example.domain.pojo.SysTag;
import com.example.domain.req.SysTagQueryPageReq;
import com.example.service.SysTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysTag")
public class SysTagController {

    @Autowired
    private SysTagService sysTagService;


    @RequestMapping("/queryTagListPage")
    public TableDataInfo<?> queryTagListPage(@RequestBody SysTagQueryPageReq sysTagQueryPageReq){
        return sysTagService.queryTagListPage(sysTagQueryPageReq);
    }

    @RequestMapping("/addTag")
    public Response<?> addTag(@RequestBody SysTag sysTag){
        int i = sysTagService.addTag(sysTag);
        return Response.success(i);
    }


}
