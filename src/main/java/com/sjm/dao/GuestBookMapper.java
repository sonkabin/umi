package com.sjm.dao;

import com.sjm.domain.GuestBook;
import com.sjm.domain.GuestBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuestBookMapper {
    long countByExample(GuestBookExample example);

    int deleteByExample(GuestBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GuestBook record);

    int insertSelective(GuestBook record);

    List<GuestBook> selectByExampleWithBLOBs(GuestBookExample example);

    List<GuestBook> selectByExample(GuestBookExample example);

    GuestBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GuestBook record, @Param("example") GuestBookExample example);

    int updateByExampleWithBLOBs(@Param("record") GuestBook record, @Param("example") GuestBookExample example);

    int updateByExample(@Param("record") GuestBook record, @Param("example") GuestBookExample example);

    int updateByPrimaryKeySelective(GuestBook record);

    int updateByPrimaryKeyWithBLOBs(GuestBook record);

    int updateByPrimaryKey(GuestBook record);
}