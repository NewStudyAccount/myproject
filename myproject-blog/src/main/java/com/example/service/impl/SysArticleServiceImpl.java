package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysArticle;
import com.example.mapper.SysArticleMapper;
import com.example.service.SysArticleService;
import org.springframework.stereotype.Service;

/**
* @author QJJ
* @description 针对表【sys_article(文章表)】的数据库操作Service实现
* @createDate 2025-04-01 23:31:09
*/
@Service
public class SysArticleServiceImpl extends ServiceImpl<SysArticleMapper, SysArticle>
    implements SysArticleService {

    /**
     * 新建文章，打开一个页面，输入标题，分类等。点击创建，
     * @param sysArticle
     * @return
     */
    @Override
    public int saveArticle(SysArticle sysArticle) {

        this.baseMapper.insert(sysArticle);


        return 0;
    }
}




