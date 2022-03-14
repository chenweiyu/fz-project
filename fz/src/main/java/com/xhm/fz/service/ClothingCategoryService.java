package com.xhm.fz.service;

import com.xhm.fz.dto.ClothingCategoryParam;
import com.xhm.fz.dto.ClothingCategoryWithChildrenItem;
import com.xhm.fz.entity.ClothingCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品分类管理Service
 * Created by xhm on 2018/4/26.
 */
public interface ClothingCategoryService {
    /**
     * 创建商品分类
     */
    @Transactional
    int create(ClothingCategoryParam clothingCategoryParam);

    /**
     * 修改商品分类
     */
    @Transactional
    int update(Long id, ClothingCategoryParam clothingCategoryParam);

    /**
     * 分页获取商品分类
     */
    List<ClothingCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 删除商品分类
     */
    int delete(Long id);

    /**
     * 根据ID获取商品分类
     */
    ClothingCategory getItem(Long id);

    /**
     * 批量修改导航状态
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 批量修改显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 以层级形式获取商品分类
     */
    List<ClothingCategoryWithChildrenItem> listWithChildren();
}
