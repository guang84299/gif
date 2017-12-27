package com.guang.gif.mapper;

import com.guang.gif.pojo.CommentLove;
import com.guang.gif.pojo.CommentLoveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentLoveMapper {
    int countByExample(CommentLoveExample example);

    int deleteByExample(CommentLoveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentLove record);

    int insertSelective(CommentLove record);

    List<CommentLove> selectByExample(CommentLoveExample example);

    CommentLove selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentLove record, @Param("example") CommentLoveExample example);

    int updateByExample(@Param("record") CommentLove record, @Param("example") CommentLoveExample example);

    int updateByPrimaryKeySelective(CommentLove record);

    int updateByPrimaryKey(CommentLove record);
}