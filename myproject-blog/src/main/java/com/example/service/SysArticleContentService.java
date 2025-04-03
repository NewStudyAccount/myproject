package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.SysArticleContent;
import com.example.domain.vo.SysArticleContentVo;

/**
* @author QJJ
* @description 针对表【sys_article_content(文章内容)】的数据库操作Service
* @createDate 2025-04-01 23:31:09
*/
public interface SysArticleContentService extends IService<SysArticleContent> {

    public int saveArticleContent(SysArticleContent sysArticleContent);

    public SysArticleContent getArticleContent(Long articleId);

    public SysArticleContentVo getArticleContentWithConvert(Long articleId);
}
