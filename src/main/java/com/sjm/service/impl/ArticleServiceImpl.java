package com.sjm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.dao.ArticleMapper;
import com.sjm.domain.Article;
import com.sjm.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public int saveArticle(Article article,int userId) {
		article.setCreateTime(new Date());
		article.setUserId(userId);
		int articleId = articleMapper.insertSelective(article);
		return articleId;
	}
}
