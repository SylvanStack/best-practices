package com.bp.scaffolding.service.restful;

import com.bp.scaffolding.model.restful.Article;

/**
 * @description: 文章服务类
 * @author: hansiyuan
 * @date: 2022/3/2 3:09 PM
 */
public interface ArticleService {
    /**
     * 文章保存
     */
    String saveArticle(Article article);
}
