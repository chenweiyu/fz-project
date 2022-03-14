package com.xhm.fz.mapper;

import com.xhm.fz.entity.PrefrenceAreaClothingRelation;
import com.xhm.fz.entity.PrefrenceAreaClothingRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrefrenceAreaClothingRelationMapper {
    long countByExample(PrefrenceAreaClothingRelationExample example);

    int deleteByExample(PrefrenceAreaClothingRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PrefrenceAreaClothingRelation record);

    int insertSelective(PrefrenceAreaClothingRelation record);

    List<PrefrenceAreaClothingRelation> selectByExample(PrefrenceAreaClothingRelationExample example);

    PrefrenceAreaClothingRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PrefrenceAreaClothingRelation record, @Param("example") PrefrenceAreaClothingRelationExample example);

    int updateByExample(@Param("record") PrefrenceAreaClothingRelation record, @Param("example") PrefrenceAreaClothingRelationExample example);

    int updateByPrimaryKeySelective(PrefrenceAreaClothingRelation record);

    int updateByPrimaryKey(PrefrenceAreaClothingRelation record);
}