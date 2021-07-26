package com.tian.service.impl;



import com.tian.entity.Article;
import com.tian.repository.ArticleRepository;
import com.tian.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    public Article findArticleById(long id) {
        return articleRepository.findById(id);
    }



}

