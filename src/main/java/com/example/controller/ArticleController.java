package com.example.controller;

import com.example.dao.ArticleDao;
import com.example.pojo.Article;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @PostMapping("/emps")      //这里编不出来，似乎参数无法提取
    public String addEmp(@RequestParam(required = false) Article article){
        articleDao.add(article);
        return "redirect:/article";
    }


    //删除
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        articleDao.delete(id);
        return "redirect:/article";
    }




}
