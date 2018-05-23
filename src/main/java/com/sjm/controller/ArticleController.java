package com.sjm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjm.domain.Article;
import com.sjm.service.ArticleLabelService;
import com.sjm.service.ArticleService;
import com.sjm.util.Message;


@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private ArticleLabelService articleLabelService;

    @RequestMapping(value = "/articles" , method = RequestMethod.POST)
    public Message saveArticle(@RequestParam("tags")String tags,Article article,HttpSession session){
    	int userId = (int)session.getAttribute("userId");
    	int articleId = articleService.saveArticle(article,userId);
    	articleLabelService.saveArticleLabel(articleId,tags);
        return Message.success();
    }

    @RequestMapping(value = "/articles" , method = RequestMethod.GET)
    public Message getArticles(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
    	
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
