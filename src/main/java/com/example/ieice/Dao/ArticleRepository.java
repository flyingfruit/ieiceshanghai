package com.example.ieice.Dao;

import com.example.ieice.Bean.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

    public interface ArticleRepository extends ElasticsearchRepository<Article,Long> {
    List<Article> findByTitleAndContext(String string);
    List<Article> findByTitleInOrContextIn(Collection<String> title, Collection<String> context);

}
