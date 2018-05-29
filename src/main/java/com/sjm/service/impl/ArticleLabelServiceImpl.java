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
	public void saveArticleLabel(Integer articleId, String tags) {
		ArticleLabel record = new ArticleLabel();
		record.setArticleId(articleId);
		record.setLabels(tags);
		articleLabelMapper.insertSelective(record);
	}

	@Override
	public ArticleLabel findLabels(Integer id) {
		ArticleLabelExample example = new ArticleLabelExample();
		example.createCriteria().andArticleIdEqualTo(id);
		List<ArticleLabel> list = articleLabelMapper.selectByExample(example);
		//一篇文章对应的标签只有一行，所以取出第一条数据即可
		return list.get(0);
	}

	@Override
	public void updateLabels(Integer id, String tags) {
		ArticleLabel record = new ArticleLabel();
		record.setId(id);
		record.setLabels(tags);
		articleLabelMapper.updateByPrimaryKeySelective(record);
	}

}
