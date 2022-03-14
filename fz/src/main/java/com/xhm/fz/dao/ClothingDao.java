package com.xhm.fz.dao;

import com.xhm.fz.dto.ClothingResult;
import org.apache.ibatis.annotations.Param;


/**
 * 商品管理自定义Dao
 * Created by xhm on 2018/4/26.
 */
public interface ClothingDao {
    /**
     * 获取商品编辑信息
     */
    ClothingResult getUpdateInfo(@Param("id") Long id);
}
