package com.sjm.dao;

import com.sjm.domain.Label;
import com.sjm.domain.LabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabelMapper {
    long countByExample(LabelExample example);

    int deleteByExample(LabelExample example);

    int deleteByPrimaryKey(Integer labelId);

    int insert(Label record);

    int insertSelective(Label record);

    List<Label> selectByExample(LabelExample example);

    Label selectByPrimaryKey(Integer labelId);

    int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelExample example);

    int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}