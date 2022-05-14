package com.xhm.fz.service;

import java.util.List;

import com.xhm.fz.dto.ReceiverParam;
import com.xhm.fz.entity.Receiver;

public interface ReceiverService {

    List<Receiver> list(Long uid);

    int update(Long id, ReceiverParam receiverParam);
    
}
