package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysArticleCategoryRel;
import com.example.mapper.SysArticleCategoryRelMapper;
import com.example.service.SysArticleCategoryRelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author QJJ
* @description 针对表【sys_article_category_rel】的数据库操作Service实现
* @createDate 2025-04-01 23:31:09
*/
@Service
public class SysArticleCategoryRelServiceImpl extends ServiceImpl<SysArticleCategoryRelMapper, SysArticleCategoryRel>
    implements SysArticleCategoryRelService {


    @Override
    public List<SysArticleCategoryRel> getArticleCategoryRelList(SysArticleCategoryRel sysArticleCategoryRel) {
        return List.of();
    }

    @Override
    public int addArticleCategoryRel(SysArticleCategoryRel sysArticleCategoryRel) {
        return 0;
    }

    @Override
    public int deleteArticleCategoryRel(SysArticleCategoryRel sysArticleCategoryRel) {
        return 0;
    }
}




