package com.xhm.fz.service;

import com.xhm.fz.entity.User;

/**
 * @Author xhm
 * @Date 2020/5/27 17:36
 */
public interface UserService {
    User getUserByUserName(String username);

    boolean checkLogin(String username,String rawPassword) throws Exception;
}
