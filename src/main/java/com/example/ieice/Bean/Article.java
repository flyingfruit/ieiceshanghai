package com.example.ieice.Bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "article",type = "article")
public class Article {
    @Id
    @Field(type= FieldType.Long,store=false,index = false)
    private Long id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type=FieldType.Text)
    private String context;

    public Article(){};
    public Article(Long id,String title,String context){
        this.id=id;
        this.title=title;
        this.context=context;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public Long getId() {
        return id;
    }
}
