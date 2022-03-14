package com.xhm.fz.dao;

import com.xhm.fz.entity.PrefrenceAreaClothingRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优选和商品关系自定义Dao
 * Created by xhm on 2018/4/26.
 */
public interface PrefrenceAreaClothingRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PrefrenceAreaClothingRelation> prefrenceAreaClothingRelationList);
}
