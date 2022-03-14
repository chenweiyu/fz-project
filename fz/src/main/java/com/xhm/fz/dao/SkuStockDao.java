package com.xhm.fz.dao;

import com.xhm.fz.entity.SkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品SKU管理自定义Dao
 * Created by xhm on 2018/4/26.
 */
public interface SkuStockDao {
    /**
     * 批量插入操作
     */
    int insertList(@Param("list")List<SkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(@Param("list")List<SkuStock> skuStockList);
}
