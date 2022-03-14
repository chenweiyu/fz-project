package com.xhm.fz.dao;

import com.xhm.fz.entity.OrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单操作记录自定义Dao
 * Created by xhm on 2018/10/12.
 */
public interface OrderOperateHistoryDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<OrderOperateHistory> orderOperateHistoryList);
}
