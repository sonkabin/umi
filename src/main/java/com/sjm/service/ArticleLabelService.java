package com.sjm.service;

import com.sjm.domain.ArticleLabel;

public interface ArticleLabelService {

	void saveArticleLabel(Integer articleId, String tags);

	ArticleLabel findLabels(Integer id);

	void updateLabels(Integer id, String tags);

}
