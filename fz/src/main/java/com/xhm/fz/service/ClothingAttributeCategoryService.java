package com.xhm.fz.service;

import com.xhm.fz.dto.ClothingAttributeCategoryItem;
import com.xhm.fz.entity.ClothingAttributeCategory;

import java.util.List;

/**
 * 商品属性分类管理Service
 * Created by xhm on 2018/4/26.
 */
public interface ClothingAttributeCategoryService {
    /**
     * 创建属性分类
     */
    int create(String name);

    /**
     * 修改属性分类
     */
    int update(Long id, String name);

    /**
     * 删除属性分类
     */
    int delete(Long id);

    /**
     * 获取属性分类详情
     */
    ClothingAttributeCategory getItem(Long id);

    /**
     * 分页查询属性分类
     */
    List<ClothingAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * 获取包含属性的属性分类
     */
    List<ClothingAttributeCategoryItem> getListWithAttr();
}
