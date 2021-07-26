package com.tian.service;





import com.tian.entity.Article;

import java.util.List;

public interface ArticleService {
    public List<Article> getArticleList();
    public  Article findArticleById(long id);

}
