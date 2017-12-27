package com.guang.gif.mapper;

import com.guang.gif.pojo.Love;
import com.guang.gif.pojo.LoveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoveMapper {
    int countByExample(LoveExample example);

    int deleteByExample(LoveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Love record);

    int insertSelective(Love record);

    List<Love> selectByExample(LoveExample example);

    Love selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Love record, @Param("example") LoveExample example);

    int updateByExample(@Param("record") Love record, @Param("example") LoveExample example);

    int updateByPrimaryKeySelective(Love record);

    int updateByPrimaryKey(Love record);
}