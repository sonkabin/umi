package com.sjm.service;

import java.util.List;

public interface ArticleLabelService {

	void saveArticleLabel(int articleId, String tagIds);

	List<Integer> findLabelIds(Integer id);

}
