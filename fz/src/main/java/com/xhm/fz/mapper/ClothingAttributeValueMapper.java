package com.xhm.fz.mapper;

import com.xhm.fz.entity.ClothingAttributeValue;
import com.xhm.fz.entity.ClothingAttributeValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothingAttributeValueMapper {
    long countByExample(ClothingAttributeValueExample example);

    int deleteByExample(ClothingAttributeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClothingAttributeValue record);

    int insertSelective(ClothingAttributeValue record);

    List<ClothingAttributeValue> selectByExample(ClothingAttributeValueExample example);

    ClothingAttributeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClothingAttributeValue record, @Param("example") ClothingAttributeValueExample example);

    int updateByExample(@Param("record") ClothingAttributeValue record, @Param("example") ClothingAttributeValueExample example);

    int updateByPrimaryKeySelective(ClothingAttributeValue record);

    int updateByPrimaryKey(ClothingAttributeValue record);
}