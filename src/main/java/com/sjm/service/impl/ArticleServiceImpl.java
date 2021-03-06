package com.sjm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.dao.ArticleMapper;
import com.sjm.domain.Article;
import com.sjm.domain.ArticleExample;
import com.sjm.domain.ArticleExample.Criteria;
import com.sjm.dto.ArticleDTO;
import com.sjm.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public Integer saveArticle(Article article,int userId) {
		article.setCreateTime(new Date());
		article.setUserId(userId);
		articleMapper.insertSelective(article);
		Integer articleId = article.getArticleId();
		return articleId;
	}

	@Override
	public List<Article> getArticles(ArticleDTO dto) {
		ArticleExample example = new ArticleExample();
		Criteria criteria = example.createCriteria();
		if(dto.getTitle() != null) {
			criteria.andTitleLike("%" + dto.getTitle() + "%");
		}else {
			//来自首页的请求
			example.setOrderByClause("a.create_time desc");
		}
		if(dto.getStartTime() != null) {
			criteria.andCreateTimeGreaterThanOrEqualTo(dto.getStartTime());
		}
		if(dto.getEndTime() != null) {
			criteria.andCreateTimeLessThanOrEqualTo(dto.getEndTime());
		}
		List<Article> list = articleMapper.selectByExampleWithUser(example);
		return list;
	}

	@Override
	public Article findArticle(Integer id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateArticle(Article article) {
		articleMapper.updateByPrimaryKeySelective(article);
	}

	@Override
	public void deleteArticle(Integer id) {
		articleMapper.deleteByPrimaryKey(id);
	}
}
