package com.example.controller;

import com.example.domain.Response;
import com.example.domain.req.SysArticleContentReq;
import com.example.domain.vo.SysArticleContentVo;
import com.example.service.SysArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article/content")
public class SysArticleContentController {

    @Autowired
    private SysArticleContentService sysArticleContentService;


    @PostMapping("/queryById")
    public Response queryArticleContentWithConvert(@RequestBody SysArticleContentReq articleContentReq) {

        SysArticleContentVo articleContentWithConvert = sysArticleContentService.getArticleContentWithConvert(articleContentReq.getArticleId());

        return Response.success(articleContentWithConvert);
    }


}
