package com.xhm.fz.dao;

import com.xhm.fz.dto.OrderReturnApplyResult;
import com.xhm.fz.dto.ReturnApplyQueryParam;
import com.xhm.fz.entity.OrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 * Created by xhm on 2018/10/18.
 */
public interface OrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OrderReturnApply> getList(@Param("queryParam") ReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OrderReturnApplyResult getDetail(@Param("id")Long id);
}
