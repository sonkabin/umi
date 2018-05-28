package com.sjm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjm.domain.Article;
import com.sjm.domain.ArticleLabel;
import com.sjm.dto.ArticleDTO;
import com.sjm.service.ArticleLabelService;
import com.sjm.service.ArticleService;
import com.sjm.util.Message;


@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private ArticleLabelService articleLabelService;

    @RequestMapping(value = "/article" , method = RequestMethod.POST)
    public Message saveArticle(@RequestParam("tags")String tags,Article article,HttpSession session){
    	int userId = (int)session.getAttribute("userId");
    	int articleId = articleService.saveArticle(article,userId);
    	articleLabelService.saveArticleLabel(articleId,tags);
        return Message.success();
    }

    @RequestMapping(value = "/articles" , method = RequestMethod.GET)
    public Message getArticles(@RequestParam(value = "pn",defaultValue = "1")Integer pn,ArticleDTO dto){
    	PageHelper.startPage(pn, 5);
    	List<Article> list = articleService.getArticles(dto);
    	PageInfo<?> pageInfo = new PageInfo<>(list, 5);
        return Message.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/article/{id}" , method = RequestMethod.GET)
    public Message getArticle(@PathVariable("id")Integer id){
    	Article article = articleService.findArticle(id);
    	List<ArticleLabel> tags = articleLabelService.findLabels(id);
        return Message.success().add("article", article).add("tags", tags);
    }

    @RequestMapping(value = "/article/{articleId}" , method = RequestMethod.PUT)
    public Message updateArticle(Article article){
    	articleService.updateArticle(article);
        return Message.success();
    }

    @RequestMapping(value = "/article/{id}" , method = RequestMethod.DELETE)
    public Message deleteArticl(@PathVariable("id")Integer id){
    	articleService.deleteArticle(id);
        return Message.success();
    }
}
