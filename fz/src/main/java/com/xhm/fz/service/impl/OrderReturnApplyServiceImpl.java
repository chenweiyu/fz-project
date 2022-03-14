package com.xhm.fz.service.impl;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.dao.OrderReturnApplyDao;
import com.xhm.fz.dto.OrderReturnApplyResult;
import com.xhm.fz.dto.ReturnApplyQueryParam;
import com.xhm.fz.dto.UpdateStatusParam;
import com.xhm.fz.mapper.OrderReturnApplyMapper;
import com.xhm.fz.entity.OrderReturnApply;
import com.xhm.fz.entity.OrderReturnApplyExample;
import com.xhm.fz.service.OrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单退货管理Service实现类
 * Created by xhm on 2018/10/18.
 */
@Service
public class OrderReturnApplyServiceImpl implements OrderReturnApplyService {
    @Autowired
    private OrderReturnApplyDao returnApplyDao;
    @Autowired
    private OrderReturnApplyMapper returnApplyMapper;
    @Override
    public List<OrderReturnApply> list(ReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return returnApplyDao.getList(queryParam);
    }

    @Override
    public int delete(List<Long> ids) {
        OrderReturnApplyExample example = new OrderReturnApplyExample();
        example.createCriteria().andIdIn(ids).andStatusEqualTo(3);
        return returnApplyMapper.deleteByExample(example);
    }

    @Override
    public int updateStatus(Long id, UpdateStatusParam statusParam) {
        Integer status = statusParam.getStatus();
        OrderReturnApply returnApply = new OrderReturnApply();
        if(status.equals(1)){
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else if(status.equals(2)){
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        }else if(status.equals(3)){
            //拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else{
            return 0;
        }
        return returnApplyMapper.updateByPrimaryKeySelective(returnApply);
    }

    @Override
    public OrderReturnApplyResult getItem(Long id) {
        return returnApplyDao.getDetail(id);
    }
}
