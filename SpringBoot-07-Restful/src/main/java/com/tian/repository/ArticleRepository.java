package com.tian.repository;



import com.tian.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleRepository extends JpaRepository<Article,Long>, JpaSpecificationExecutor<Article> {
    Article findById(long id);

}
