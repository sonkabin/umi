package com.sjm.service;

import java.util.List;

import com.sjm.domain.Article;
import com.sjm.dto.ArticleDTO;

public interface ArticleService {

	int saveArticle(Article article, int userId);

	List<Article> getArticles(ArticleDTO dto);

	Article findArticle(Integer id);

	void updateArticle(Article article);

	void deleteArticle(Integer id);
}
