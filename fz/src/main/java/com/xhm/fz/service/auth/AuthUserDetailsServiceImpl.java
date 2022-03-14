package com.xhm.fz.service.auth;

import com.xhm.fz.entity.User;
import com.xhm.fz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 要实现UserDetailsService接口，这个接口是security提供的
 */
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * 通过账号查找用户、角色的信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }else {
            return new AuthUser(user.getUsername(), user.getPassword(), user.getState(), user.getAuthorities());
        }
    }
}
