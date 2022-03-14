package com.xhm.fz.dao;

import com.xhm.fz.entity.MemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员价格管理自定义Dao
 * Created by xhm on 2018/4/26.
 */
public interface MemberPriceDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<MemberPrice> memberPriceList);
}
