package com.xhm.fz.mapper;

import com.xhm.fz.entity.ClothingAttributeCategory;
import com.xhm.fz.entity.ClothingAttributeCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothingAttributeCategoryMapper {
    long countByExample(ClothingAttributeCategoryExample example);

    int deleteByExample(ClothingAttributeCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClothingAttributeCategory record);

    int insertSelective(ClothingAttributeCategory record);

    List<ClothingAttributeCategory> selectByExample(ClothingAttributeCategoryExample example);

    ClothingAttributeCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClothingAttributeCategory record, @Param("example") ClothingAttributeCategoryExample example);

    int updateByExample(@Param("record") ClothingAttributeCategory record, @Param("example") ClothingAttributeCategoryExample example);

    int updateByPrimaryKeySelective(ClothingAttributeCategory record);

    int updateByPrimaryKey(ClothingAttributeCategory record);
}