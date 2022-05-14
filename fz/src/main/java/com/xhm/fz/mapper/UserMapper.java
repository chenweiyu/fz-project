package com.xhm.fz.mapper;

import java.util.List;

import com.xhm.fz.entity.User;
import com.xhm.fz.entity.UserExample;

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

    int updateByIdUser(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int deleteByExample(UserExample example);
}
