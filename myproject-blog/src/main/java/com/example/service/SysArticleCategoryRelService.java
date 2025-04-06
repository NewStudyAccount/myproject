package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.SysArticleCategoryRel;

import java.util.List;

/**
* @author QJJ
* @description 针对表【sys_article_category_rel】的数据库操作Service
* @createDate 2025-04-01 23:31:09
*/
public interface SysArticleCategoryRelService extends IService<SysArticleCategoryRel> {

    List<SysArticleCategoryRel> getArticleCategoryRelList(SysArticleCategoryRel sysArticleCategoryRel);

    int addArticleCategoryRel(SysArticleCategoryRel sysArticleCategoryRel);

    int deleteArticleCategoryRel(SysArticleCategoryRel sysArticleCategoryRel);

}
