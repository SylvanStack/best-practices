package com.bp.scaffolding.service;

import com.bp.scaffolding.common.model.Article;

/**
 * @description: 文章服务类
 * @author: hansiyuan
 * @date: 2022/3/2 3:09 PM
 */
public interface ArticleService {

    /**
     * 保存文章信息
     *
     * @param article 文章
     * @return 保存结果
     */
    String saveArticle(Article article);
}
