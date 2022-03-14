package com.xhm.fz.mapper;

import com.xhm.fz.entity.ClothingAttribute;
import com.xhm.fz.entity.ClothingAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothingAttributeMapper {
    long countByExample(ClothingAttributeExample example);

    int deleteByExample(ClothingAttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClothingAttribute record);

    int insertSelective(ClothingAttribute record);

    List<ClothingAttribute> selectByExample(ClothingAttributeExample example);

    ClothingAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClothingAttribute record, @Param("example") ClothingAttributeExample example);

    int updateByExample(@Param("record") ClothingAttribute record, @Param("example") ClothingAttributeExample example);

    int updateByPrimaryKeySelective(ClothingAttribute record);

    int updateByPrimaryKey(ClothingAttribute record);
}