package com.xhm.fz.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by macro on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.xhm.fz.mapper","com.xhm.fz.dao"})
public class MyBatisConfig {
}
