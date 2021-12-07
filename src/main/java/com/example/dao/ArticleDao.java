package com.example.dao;
import com.example.pojo.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor

@Repository
public class ArticleDao {

    private static Map<Integer , Article> articles = null; //编排格式 articles(整数， Article的值) 键值对

    static {
        articles = new HashMap<>(); //HashMap 继承了的map的接口，主要是实现hash表的，目的是key值不重复
        articles.put(101,new Article(101,"水浒","108好汉"));
        articles.put(102,new Article(102,"西游记","大唐gang"));
        articles.put(103,new Article(103,"三国","汉室衰微，三国鼎立"));
        articles.put(104,new Article(104,"红楼","封建真爱"));
    }

    //主键自增
    private static Integer initId = 105;

    //add

    public void add(Article article){
        if (article.getId()==null){
            article.setId(initId++);
        }
        articles.put(article.getId(),article);

    }

    //查询单个

    public Article searchOne(Integer id){
        return articles.get(id);
    }

    //查询全部
    public Collection<Article> searchAll(){
        return articles.values();
    }

    //删除

    public void delete(Integer id){
        articles.remove(id);
    }


}
