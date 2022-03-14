package com.xhm.fz.mapper;

import com.xhm.fz.entity.ClothingCategoryAttributeRelation;
import com.xhm.fz.entity.ClothingCategoryAttributeRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothingCategoryAttributeRelationMapper {
    long countByExample(ClothingCategoryAttributeRelationExample example);

    int deleteByExample(ClothingCategoryAttributeRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClothingCategoryAttributeRelation record);

    int insertSelective(ClothingCategoryAttributeRelation record);

    List<ClothingCategoryAttributeRelation> selectByExample(ClothingCategoryAttributeRelationExample example);

    ClothingCategoryAttributeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClothingCategoryAttributeRelation record, @Param("example") ClothingCategoryAttributeRelationExample example);

    int updateByExample(@Param("record") ClothingCategoryAttributeRelation record, @Param("example") ClothingCategoryAttributeRelationExample example);

    int updateByPrimaryKeySelective(ClothingCategoryAttributeRelation record);

    int updateByPrimaryKey(ClothingCategoryAttributeRelation record);
}