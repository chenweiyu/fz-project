package com.xhm.fz.dao;

import com.xhm.fz.dto.ClothingCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义Dao
 * Created by xhm on 2018/5/25.
 */
public interface ClothingCategoryDao {
    /**
     * 获取商品分类及其子分类
     */
    List<ClothingCategoryWithChildrenItem> listWithChildren();
}
