package com.xhm.fz.service;

import com.xhm.fz.entity.OrderReturnReason;

import java.util.List;

public interface OrderReturnReasonService {
    /**
     * 添加退货原因
     */
    int create(OrderReturnReason returnReason);

    /**
     * 修改退货原因
     */
    int update(Long id, OrderReturnReason returnReason);

    /**
     * 批量删除退货原因
     */
    int delete(List<Long> ids);

    /**
     * 分页获取退货原因
     */
    List<OrderReturnReason> list(Integer pageSize, Integer pageNum);

    List<OrderReturnReason> usefulList();

    /**
     * 批量修改退货原因状态
     */
    int updateStatus(List<Long> ids, Integer status);

    /**
     * 获取单个退货原因详情信息
     */
    OrderReturnReason getItem(Long id);
}
