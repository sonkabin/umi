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
	public int saveArticle(Article article,int userId) {
		article.setCreateTime(new Date());
		article.setUserId(userId);
		int articleId = articleMapper.insertSelective(article);
		return articleId;
	}

	@Override
	public List<Article> getArticles(ArticleDTO dto) {
		ArticleExample example = new ArticleExample();
		Criteria criteria = example.createCriteria().andTitleLike("%" + dto.getTitle() + "%");
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
