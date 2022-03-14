package com.xhm.fz.dao;

import com.xhm.fz.entity.ClothingAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数/规格属性自定义Dao
 * Created by xhm on 2018/4/26.
 */
public interface ClothingAttributeValueDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<ClothingAttributeValue> clothingAttributeValueList);
}
