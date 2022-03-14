package com.xhm.fz.mapper;

import com.xhm.fz.entity.ClothingFullReduction;
import com.xhm.fz.entity.ClothingFullReductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothingFullReductionMapper {
    long countByExample(ClothingFullReductionExample example);

    int deleteByExample(ClothingFullReductionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClothingFullReduction record);

    int insertSelective(ClothingFullReduction record);

    List<ClothingFullReduction> selectByExample(ClothingFullReductionExample example);

    ClothingFullReduction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClothingFullReduction record, @Param("example") ClothingFullReductionExample example);

    int updateByExample(@Param("record") ClothingFullReduction record, @Param("example") ClothingFullReductionExample example);

    int updateByPrimaryKeySelective(ClothingFullReduction record);

    int updateByPrimaryKey(ClothingFullReduction record);
}