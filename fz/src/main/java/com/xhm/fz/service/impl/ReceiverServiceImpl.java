package com.xhm.fz.service.impl;

import java.util.List;

import com.xhm.fz.dto.ReceiverParam;
import com.xhm.fz.entity.Receiver;
import com.xhm.fz.mapper.ReceiverMapper;
import com.xhm.fz.service.ReceiverService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    ReceiverMapper receiverMapper;

    @Override
    public List<Receiver> list(Long uid) {
        return receiverMapper.selectByExample(uid);
    }

    @Override
    public int update(Long id, ReceiverParam receiverParam) {
        Receiver receiver = new Receiver();
        receiver.setId(id);
        BeanUtils.copyProperties(receiverParam, receiver);
        return receiverMapper.updateByPrimaryKeySelective(receiver);
    }
    
}
