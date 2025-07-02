package com.example.controller;

import com.example.domain.Response;
import com.example.domain.pojo.SysArticle;
import com.example.service.SysArticleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "文章接口")
@RestController
@RequestMapping("/article")
public class SysArticleController {

    @Autowired
    private SysArticleService sysArticleService;

    @RequestMapping("/save")
    public Response<?> saveArticle(SysArticle sysArticle){
        return Response.success(sysArticleService.saveArticle(sysArticle));
    }
}
