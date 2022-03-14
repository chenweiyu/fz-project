package com.xhm.fz.mapper;

import com.xhm.fz.entity.ClothingLadder;
import com.xhm.fz.entity.ClothingLadderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothingLadderMapper {
    long countByExample(ClothingLadderExample example);

    int deleteByExample(ClothingLadderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClothingLadder record);

    int insertSelective(ClothingLadder record);

    List<ClothingLadder> selectByExample(ClothingLadderExample example);

    ClothingLadder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClothingLadder record, @Param("example") ClothingLadderExample example);

    int updateByExample(@Param("record") ClothingLadder record, @Param("example") ClothingLadderExample example);

    int updateByPrimaryKeySelective(ClothingLadder record);

    int updateByPrimaryKey(ClothingLadder record);
}