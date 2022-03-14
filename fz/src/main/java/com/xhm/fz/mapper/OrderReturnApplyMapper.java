package com.xhm.fz.mapper;

import com.xhm.fz.entity.OrderReturnApply;
import com.xhm.fz.entity.OrderReturnApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReturnApplyMapper {
    long countByExample(OrderReturnApplyExample example);

    int deleteByExample(OrderReturnApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderReturnApply record);

    int insertSelective(OrderReturnApply record);

    List<OrderReturnApply> selectByExample(OrderReturnApplyExample example);

    OrderReturnApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderReturnApply record, @Param("example") OrderReturnApplyExample example);

    int updateByExample(@Param("record") OrderReturnApply record, @Param("example") OrderReturnApplyExample example);

    int updateByPrimaryKeySelective(OrderReturnApply record);

    int updateByPrimaryKey(OrderReturnApply record);
}