package com.sjm.dao;

import com.sjm.domain.BlogSetting;
import com.sjm.domain.BlogSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogSettingMapper {
    long countByExample(BlogSettingExample example);

    int deleteByExample(BlogSettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogSetting record);

    int insertSelective(BlogSetting record);

    List<BlogSetting> selectByExample(BlogSettingExample example);

    BlogSetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogSetting record, @Param("example") BlogSettingExample example);

    int updateByExample(@Param("record") BlogSetting record, @Param("example") BlogSettingExample example);

    int updateByPrimaryKeySelective(BlogSetting record);

    int updateByPrimaryKey(BlogSetting record);
}