package com.xhm.fz.mapper;

import java.util.List;

import com.xhm.fz.entity.SkuStock;
import com.xhm.fz.entity.SkuStockExample;

public interface SkuStockMapper {
    // long countByExample(SkuStockExample example);

    int deleteByExample(SkuStockExample example);

    // int deleteByPrimaryKey(Long id);

    // int insert(SkuStock record);

    // int insertSelective(SkuStock record);

    List<SkuStock> selectByExample(SkuStockExample example);

    // SkuStock selectByPrimaryKey(Long id);

    // int updateByExampleSelective(@Param("record") SkuStock record, @Param("example") SkuStockExample example);

    // int updateByExample(@Param("record") SkuStock record, @Param("example") SkuStockExample example);

    int updateByPrimaryKeySelective(SkuStock record);

    // int updateByPrimaryKey(SkuStock record);
}