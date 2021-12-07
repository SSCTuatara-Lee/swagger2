package com.example.controller;

import com.example.dao.ArticleDao;
import com.example.pojo.Article;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@Controller
public class ArticleController {

    @Autowired
    ArticleDao articleDao;



    @RequestMapping("/article")
    public String article(Model model) {

        Collection<Article> articles = articleDao.searchAll();  //集合结构体定义，令articles具有Article构造的结构体
        model.addAttribute("list", articles);
        return "article";
    }

    @GetMapping("/emp")
    public String toAdd(){
        return "add";
    }



    @PostMapping(value = "/emps",produces = {MediaType.APPLICATION_JSON_VALUE})
    public String addEmp(@RequestParam("title") String title,@RequestParam("summary") String summary){
        final val article = new Article(null, title, summary);
        articleDao.add(article);
        return "redirect:/article";
    }


    @PostMapping(value = "/search",produces = {MediaType.APPLICATION_JSON_VALUE})
    public String searchSing(Model model,@RequestParam("id") Integer id){
        Article article = articleDao.searchOne(id);
        model.addAttribute("temps",article);
        return "search";
    }



    //删除
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        articleDao.delete(id);
        return "redirect:/article";
    }




}
