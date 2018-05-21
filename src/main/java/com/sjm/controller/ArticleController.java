package com.sjm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sjm.domain.Article;
import com.sjm.service.ArticleService;
import com.sjm.util.Message;


@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles" , method = RequestMethod.POST)
    public Message saveArticle(Article article){

        return Message.success();
    }

    @RequestMapping(value = "/articles" , method = RequestMethod.GET)
    public Message getArticles(){

        return Message.success();
    }

    @RequestMapping(value = "/articles/{id}" , method = RequestMethod.GET)
    public Message getArticle(@PathVariable("id")Integer id){

        return Message.success();
    }

    @RequestMapping(value = "/article/{id}" , method = RequestMethod.PUT)
    public Message updateArticle(Article article){

        return Message.success();
    }

    @RequestMapping(value = "/article/{id}" , method = RequestMethod.DELETE)
    public Message deleteArticl(@PathVariable("id")Integer id){

        return Message.success();
    }
}
