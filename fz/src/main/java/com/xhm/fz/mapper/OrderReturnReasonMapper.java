package com.xhm.fz.mapper;

import com.xhm.fz.entity.OrderReturnReason;
import com.xhm.fz.entity.OrderReturnReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReturnReasonMapper {
    long countByExample(OrderReturnReasonExample example);

    int deleteByExample(OrderReturnReasonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderReturnReason record);

    int insertSelective(OrderReturnReason record);

    List<OrderReturnReason> selectByExample(OrderReturnReasonExample example);

    OrderReturnReason selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderReturnReason record, @Param("example") OrderReturnReasonExample example);

    int updateByExample(@Param("record") OrderReturnReason record, @Param("example") OrderReturnReasonExample example);

    int updateByPrimaryKeySelective(OrderReturnReason record);

    int updateByPrimaryKey(OrderReturnReason record);
}