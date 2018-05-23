package com.sjm.service;

import com.sjm.domain.Article;

public interface ArticleService {

	int saveArticle(Article article, int userId);
}
