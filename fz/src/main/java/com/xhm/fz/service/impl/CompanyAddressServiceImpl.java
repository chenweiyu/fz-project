package com.xhm.fz.service.impl;

import com.xhm.fz.mapper.CompanyAddressMapper;
import com.xhm.fz.entity.CompanyAddress;
import com.xhm.fz.entity.CompanyAddressExample;
import com.xhm.fz.service.CompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyAddressServiceImpl implements CompanyAddressService {
    @Autowired
    private CompanyAddressMapper companyAddressMapper;
    @Override
    public List<CompanyAddress> list() {
        return companyAddressMapper.selectByExample(new CompanyAddressExample());
    }
}
