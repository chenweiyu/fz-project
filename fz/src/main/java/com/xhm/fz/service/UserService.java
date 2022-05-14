package com.xhm.fz.service;

import java.util.List;

import com.xhm.fz.dto.UserParam;
import com.xhm.fz.entity.Role;
import com.xhm.fz.entity.User;

/**
 * @Author xhm
 * @Date 2020/5/27 17:36
 */
public interface UserService {
    User getUserByUserName(String username);

    boolean checkLogin(String username,String rawPassword) throws Exception;

    int updateUser(Integer id, UserParam userParam);

    List<User> list(String keyword, Integer pageSize, Integer pageNum);

    int update(Integer id, User user);

    List<Role> getRoleList(Integer userId);

    int updateRole(Integer userId, List<Integer> roleIds);

    int delete(List<Integer> ids);

    int register(UserParam userParam);
}
