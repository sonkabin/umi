package com.sjm.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.dao.ArticleLabelMapper;
import com.sjm.domain.ArticleLabelExample;
import com.sjm.service.ArticleLabelService;

@Service
public class ArticleLabelServiceImpl implements ArticleLabelService {
	
	@Autowired
	private ArticleLabelMapper articleLabelMapper;

	@Override
	public void saveArticleLabel(int articleId, String tagIds) {
		//将标签id分割
		List<String> list = Arrays.asList(tagIds.split(","));
		articleLabelMapper.insertArticleAndTags(articleId,list);
	}

	@Override
	public List<Integer> findLabelIds(Integer id) {
		ArticleLabelExample example = new ArticleLabelExample();
		example.createCriteria().andArticleIdEqualTo(id);
		return articleLabelMapper.findLabelIds(example);
	}

}
