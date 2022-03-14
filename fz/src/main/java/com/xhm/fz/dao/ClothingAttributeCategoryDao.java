package com.xhm.fz.dao;

import com.xhm.fz.dto.ClothingAttributeCategoryItem;

import java.util.List;

/**
 * 商品属性分类管理自定义Dao
 * Created by xhm on 2018/5/24.
 */
public interface ClothingAttributeCategoryDao {
    /**
     * 获取包含属性的商品属性分类
     */
    List<ClothingAttributeCategoryItem> getListWithAttr();
}
