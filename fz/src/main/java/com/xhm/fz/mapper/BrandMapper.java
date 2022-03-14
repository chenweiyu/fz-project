package com.xhm.fz.mapper;

import java.util.List;

import com.xhm.fz.entity.Brand;
import com.xhm.fz.entity.BrandExample;

import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExampleWithBLOBs(BrandExample example);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExampleWithBLOBs(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKeyWithBLOBs(Brand record);

    int updateByPrimaryKey(Brand record);
}