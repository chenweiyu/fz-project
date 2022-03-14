package com.xhm.fz.service;

import com.xhm.fz.entity.SkuStock;

import java.util.List;

/**
 * 商品SKU库存管理Service
 * Created by xhm on 2018/4/27.
 */
public interface SkuStockService {
    /**
     * 根据产品id和skuCode关键字模糊搜索
     */
    List<SkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(Long pid, List<SkuStock> skuStockList);
}
