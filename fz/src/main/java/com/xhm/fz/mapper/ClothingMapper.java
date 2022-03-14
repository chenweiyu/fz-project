package com.xhm.fz.mapper;

import com.xhm.fz.entity.Clothing;
import com.xhm.fz.entity.ClothingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothingMapper {
    long countByExample(ClothingExample example);

    int deleteByExample(ClothingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Clothing record);

    int insertSelective(Clothing record);

    List<Clothing> selectByExampleWithBLOBs(ClothingExample example);

    List<Clothing> selectByExample(ClothingExample example);

    List<Clothing> selectByExampleWithCategoryTide(ClothingExample example);

    List<Clothing> selectByExampleWithCategorySimple(ClothingExample example);

    List<Clothing> selectByExampleWithCategorySport(ClothingExample example);

    List<Clothing> selectByExampleWithCategoryNation(ClothingExample example);

    Clothing selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Clothing record, @Param("example") ClothingExample example);

    int updateByExampleWithBLOBs(@Param("record") Clothing record, @Param("example") ClothingExample example);

    int updateByExample(@Param("record") Clothing record, @Param("example") ClothingExample example);

    int updateByPrimaryKeySelective(Clothing record);

    int updateByPrimaryKeyWithBLOBs(Clothing record);

    int updateByPrimaryKey(Clothing record);
}