package com.xhm.fz.service.impl;

import javax.annotation.Resource;

import com.xhm.fz.component.BCryptPasswordEncoderUtil;
import com.xhm.fz.entity.User;
import com.xhm.fz.mapper.UserMapper;
import com.xhm.fz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author xhm
 * @Date 2020/5/27 17:37
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    // @Override
    // public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    //     log.info("username---" + s);
    //     UserDetails userDetails = userMapper.selectByUserName("linghu");
    //     log.info("userDetails --- " + userDetails);
    //     return userDetails;
    // }

    @Override
    public User getUserByUserName(String username) {
        User user = userMapper.selectByUserName(username);
        return  user;
    }

    @Override
    public boolean checkLogin(String username,String rawPassword) throws Exception {
        User user = this.getUserByUserName(username);
        System.out.println("user = " + user);
        String encodePwd = DigestUtils.md5DigestAsHex(rawPassword.getBytes());
        if (user == null) {
            //System.out.println("checkLogin--------->账号不存在，请重新尝试！");
            //设置友好提示
            throw  new Exception("账号不存在，请重新尝试！");
        }else {
            //加密的密码
            String encodedPassword = user.getPassword();
            //和加密后的密码进行比配
            if(!encodedPassword.equals(encodePwd)) {
                //System.out.println("checkLogin--------->密码不正确！");
                //设置友好提示
                throw new Exception("密码不正确！");
            }else{
                return  true;
            }
        }
    }
}
