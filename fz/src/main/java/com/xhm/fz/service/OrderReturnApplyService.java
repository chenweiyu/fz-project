package com.xhm.fz.service;

import com.xhm.fz.dto.OrderReturnApplyResult;
import com.xhm.fz.dto.ReturnApplyQueryParam;
import com.xhm.fz.dto.UpdateStatusParam;
import com.xhm.fz.entity.OrderReturnApply;

import java.util.List;

public interface OrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OrderReturnApply> list(ReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    int createReturnApply(OrderReturnApply orderReturnApply);

    /**
     * 批量删除申请
     */
    int delete(List<Long> ids);

    /**
     * 修改指定申请状态
     */
    int updateStatus(Long id, UpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OrderReturnApplyResult getItem(Long id);
}
