package com.sjm.service;

import java.util.List;

import com.sjm.domain.ArticleLabel;

public interface ArticleLabelService {

	void saveArticleLabel(int articleId, String tags);

	List<ArticleLabel> findLabels(Integer id);

}
