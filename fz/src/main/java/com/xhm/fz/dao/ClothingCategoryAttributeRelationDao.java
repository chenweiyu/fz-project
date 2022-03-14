package com.xhm.fz.dao;

import com.xhm.fz.entity.ClothingCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类和属性关系自定义Dao
 * Created by xhm on 2018/5/23.
 */
public interface ClothingCategoryAttributeRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<ClothingCategoryAttributeRelation> clothingCategoryAttributeRelationList);
}
