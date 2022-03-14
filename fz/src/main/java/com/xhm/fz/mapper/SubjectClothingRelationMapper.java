package com.xhm.fz.mapper;

import com.xhm.fz.entity.SubjectClothingRelation;
import com.xhm.fz.entity.SubjectClothingRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectClothingRelationMapper {
    long countByExample(SubjectClothingRelationExample example);

    int deleteByExample(SubjectClothingRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubjectClothingRelation record);

    int insertSelective(SubjectClothingRelation record);

    List<SubjectClothingRelation> selectByExample(SubjectClothingRelationExample example);

    SubjectClothingRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubjectClothingRelation record, @Param("example") SubjectClothingRelationExample example);

    int updateByExample(@Param("record") SubjectClothingRelation record, @Param("example") SubjectClothingRelationExample example);

    int updateByPrimaryKeySelective(SubjectClothingRelation record);

    int updateByPrimaryKey(SubjectClothingRelation record);
}