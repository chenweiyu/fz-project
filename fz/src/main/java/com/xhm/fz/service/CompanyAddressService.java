package com.xhm.fz.service;

import com.xhm.fz.entity.CompanyAddress;

import java.util.List;


public interface CompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<CompanyAddress> list();
}
