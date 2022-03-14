package com.xhm.fz.dao;

import com.xhm.fz.entity.ClothingFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品满减自定义Dao
 * Created by xhm on 2018/4/26.
 */
public interface ClothingFullReductionDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<ClothingFullReduction> clothingFullReductionList);
}
