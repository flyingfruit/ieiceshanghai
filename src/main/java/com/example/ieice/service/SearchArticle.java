package com.example.ieice.service;

import com.example.ieice.Bean.Article;
import com.example.ieice.Dao.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchArticle {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> searchArticle(String searchUrl){
        String[] arr=searchUrl.split("\\s+");
        List<Article> articles = articleRepository.findByTitleInOrContextIn(Arrays.asList(arr),Arrays.asList(arr));
//        NativeSearchQuery query=new NativeSearchQueryBuilder().withQuery(QueryBuilders.queryStringQuery(searchUrl)).
//                withHighlightFields(new HighlightBuilder.Field("context").preTags("<span style=\"color:red\">"),
//                        new HighlightBuilder.Field("title").preTags("<span style=\"color:red\">")).build();
//        List<Article> articles =elasticsearchTemplate.queryForList(query,Article.class);
        return articles;
    }
}
