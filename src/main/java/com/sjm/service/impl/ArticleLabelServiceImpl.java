package com.sjm.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.dao.ArticleLabelMapper;
import com.sjm.service.ArticleLabelService;

@Service
public class ArticleLabelServiceImpl implements ArticleLabelService {
	
	@Autowired
	private ArticleLabelMapper articleLabelMapper;

	@Override
	public void saveArticleLabel(int articleId, String tags) {
		List<String> list = Arrays.asList(tags.split(","));
		articleLabelMapper.insertArticleAndTags(articleId,list);
	}

}
