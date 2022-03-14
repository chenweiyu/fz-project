package com.xhm.fz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.xhm.fz.mapper"})
@MapperScan(basePackages = {"com.xhm.fz.dao"})
// @ComponentScan("com.xhm.fz.config")
public class FzApplication {

	public static void main(String[] args) {
		SpringApplication.run(FzApplication.class, args);
	}

}