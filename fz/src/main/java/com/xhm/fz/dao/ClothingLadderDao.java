package com.xhm.fz.dao;

import com.xhm.fz.entity.ClothingLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员阶梯价格自定义Dao
 * Created by xhm on 2018/4/26.
 */
public interface ClothingLadderDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<ClothingLadder> clothingLadderList);
}
