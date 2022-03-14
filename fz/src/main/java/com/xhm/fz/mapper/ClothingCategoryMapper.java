package com.xhm.fz.mapper;

import com.xhm.fz.entity.ClothingCategory;
import com.xhm.fz.entity.ClothingCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothingCategoryMapper {
    long countByExample(ClothingCategoryExample example);

    int deleteByExample(ClothingCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClothingCategory record);

    int insertSelective(ClothingCategory record);

    List<ClothingCategory> selectByExampleWithBLOBs(ClothingCategoryExample example);

    List<ClothingCategory> selectByExample(ClothingCategoryExample example);

    ClothingCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClothingCategory record, @Param("example") ClothingCategoryExample example);

    int updateByExampleWithBLOBs(@Param("record") ClothingCategory record, @Param("example") ClothingCategoryExample example);

    int updateByExample(@Param("record") ClothingCategory record, @Param("example") ClothingCategoryExample example);

    int updateByPrimaryKeySelective(ClothingCategory record);

    int updateByPrimaryKeyWithBLOBs(ClothingCategory record);

    int updateByPrimaryKey(ClothingCategory record);
}