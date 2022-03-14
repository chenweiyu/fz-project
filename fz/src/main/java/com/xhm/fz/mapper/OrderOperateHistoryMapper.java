package com.xhm.fz.mapper;

import com.xhm.fz.entity.OrderOperateHistory;
import com.xhm.fz.entity.OrderOperateHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderOperateHistoryMapper {
    long countByExample(OrderOperateHistoryExample example);

    int deleteByExample(OrderOperateHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderOperateHistory record);

    int insertSelective(OrderOperateHistory record);

    List<OrderOperateHistory> selectByExample(OrderOperateHistoryExample example);

    OrderOperateHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderOperateHistory record, @Param("example") OrderOperateHistoryExample example);

    int updateByExample(@Param("record") OrderOperateHistory record, @Param("example") OrderOperateHistoryExample example);

    int updateByPrimaryKeySelective(OrderOperateHistory record);

    int updateByPrimaryKey(OrderOperateHistory record);
}