package com.xhm.fz.mapper;

import com.xhm.fz.entity.User;

/**
 * @Author xhm
 * @Date 2020/5/27 17:10
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    User selectByUserName(String username);
}
