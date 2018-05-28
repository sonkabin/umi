package com.sjm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.dao.ArticleLabelMapper;
import com.sjm.domain.ArticleLabel;
import com.sjm.domain.ArticleLabelExample;
import com.sjm.service.ArticleLabelService;

@Service
public class ArticleLabelServiceImpl implements ArticleLabelService {
	
	@Autowired
	private ArticleLabelMapper articleLabelMapper;

	@Override
	public void saveArticleLabel(int articleId, String tags) {
		ArticleLabel record = new ArticleLabel();
		record.setArticleId(articleId);
		record.setLabels(tags);
		articleLabelMapper.insertSelective(record);
	}

	@Override
	public List<ArticleLabel> findLabels(Integer id) {
		ArticleLabelExample example = new ArticleLabelExample();
		example.createCriteria().andArticleIdEqualTo(id);
		return articleLabelMapper.selectByExample(example);
	}

}
