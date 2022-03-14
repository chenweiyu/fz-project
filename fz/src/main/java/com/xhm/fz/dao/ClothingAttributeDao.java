package com.xhm.fz.dao;

import com.xhm.fz.dto.ClothingAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品属性管理自定义Dao
 * Created by xhm on 2018/5/23.
 */
public interface ClothingAttributeDao {
    /**
     * 获取商品属性信息
     */
    List<ClothingAttrInfo> getClothingAttrInfo(@Param("id") Long clothingCategoryId);
}
