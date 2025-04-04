package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysArticleContent;
import com.example.domain.vo.SysArticleContentVo;
import com.example.mapper.SysArticleContentMapper;
import com.example.service.SysArticleContentService;
import com.example.utils.MarkDownUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author QJJ
* @description 针对表【sys_article_content(文章内容)】的数据库操作Service实现
* @createDate 2025-04-01 23:31:09
*/
@Service
public class SysArticleContentServiceImpl extends ServiceImpl<SysArticleContentMapper, SysArticleContent>
    implements SysArticleContentService {

    @Override
    public int saveArticleContent(SysArticleContent sysArticleContent) {
        return this.baseMapper.insert(sysArticleContent);
    }

    @Override
    public SysArticleContent getArticleContent(Long articleId) {

        SysArticleContent sysArticleContent = this.lambdaQuery().eq(SysArticleContent::getArticleId, articleId).one();

        return sysArticleContent;
    }

    @Override
    public SysArticleContentVo getArticleContentWithConvert(Long articleId) {
        SysArticleContent sysArticleContent = this.lambdaQuery().eq(SysArticleContent::getArticleId, articleId).one();
        SysArticleContentVo sysArticleContentVo = new SysArticleContentVo();
        BeanUtils.copyProperties(sysArticleContent,sysArticleContentVo);

        //设置转换后的markdown文本信息
        String kramdownHtml = MarkDownUtil.toKramdownHtml(sysArticleContent.getContent());
        sysArticleContentVo.setContent(kramdownHtml);

        return sysArticleContentVo;
    }
}




