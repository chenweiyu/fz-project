package com.xhm.fz.mapper;

import java.util.List;

import com.xhm.fz.entity.Receiver;

public interface ReceiverMapper {

    List<Receiver> selectByExample(Long uid);

    int updateByPrimaryKeySelective(Receiver record);
    
}
