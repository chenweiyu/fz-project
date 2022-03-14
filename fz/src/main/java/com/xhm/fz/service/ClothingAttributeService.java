package com.xhm.fz.service;

import com.xhm.fz.dto.ClothingAttributeParam;
import com.xhm.fz.dto.ClothingAttrInfo;
import com.xhm.fz.entity.ClothingAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品属性管理Service
 * Created by xhm on 2018/4/26.
 */
public interface ClothingAttributeService {
    /**
     * 根据分类分页获取商品属性
     * @param cid 分类id
     * @param type 0->规格；1->参数
     */
    List<ClothingAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 添加商品属性
     */
    @Transactional
    int create(ClothingAttributeParam pmsClothingAttributeParam);

    /**
     * 修改商品属性
     */
    int update(Long id, ClothingAttributeParam clothingAttributeParam);

    /**
     * 获取单个商品属性信息
     */
    ClothingAttribute getItem(Long id);

    /**
     * 批量删除商品属性
     */
    @Transactional
    int delete(List<Long> ids);

    /**
     * 获取商品分类对应属性列表
     */
    List<ClothingAttrInfo> getClothingAttrInfo(Long clothingCategoryId);
}
