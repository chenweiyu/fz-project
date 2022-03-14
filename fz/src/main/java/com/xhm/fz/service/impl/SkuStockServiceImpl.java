package com.xhm.fz.service.impl;

import com.xhm.fz.dao.SkuStockDao;
import com.xhm.fz.mapper.SkuStockMapper;
import com.xhm.fz.entity.SkuStock;
import com.xhm.fz.entity.SkuStockExample;
import com.xhm.fz.service.SkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品SKU库存管理Service实现类
 * Created by xhm on 2018/4/27.
 */
@Service
public class SkuStockServiceImpl implements SkuStockService {
    @Autowired
    private SkuStockMapper skuStockMapper;
    @Autowired
    private SkuStockDao skuStockDao;

    @Override
    public List<SkuStock> getList(Long pid, String keyword) {
        SkuStockExample example = new SkuStockExample();
        SkuStockExample.Criteria criteria = example.createCriteria().andClothingIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public int update(Long pid, List<SkuStock> skuStockList) {
        return skuStockDao.replaceList(skuStockList);
    }
}
