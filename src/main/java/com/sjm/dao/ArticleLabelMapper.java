package com.sjm.dao;

import com.sjm.domain.ArticleLabel;
import com.sjm.domain.ArticleLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleLabelMapper {
    long countByExample(ArticleLabelExample example);

    int deleteByExample(ArticleLabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleLabel record);

    int insertSelective(ArticleLabel record);

    List<ArticleLabel> selectByExample(ArticleLabelExample example);

    ArticleLabel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleLabel record, @Param("example") ArticleLabelExample example);

    int updateByExample(@Param("record") ArticleLabel record, @Param("example") ArticleLabelExample example);

    int updateByPrimaryKeySelective(ArticleLabel record);

    int updateByPrimaryKey(ArticleLabel record);
}