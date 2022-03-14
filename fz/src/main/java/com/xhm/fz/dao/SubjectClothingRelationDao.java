package com.xhm.fz.dao;

import com.xhm.fz.entity.SubjectClothingRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品和专题关系自定义Dao
 * Created by xhm on 2018/4/26.
 */
public interface SubjectClothingRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<SubjectClothingRelation> subjectClothingRelationList);
}
