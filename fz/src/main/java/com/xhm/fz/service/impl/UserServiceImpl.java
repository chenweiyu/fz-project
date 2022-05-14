package com.xhm.fz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.component.BCryptPasswordEncoderUtil;
import com.xhm.fz.component.Md5PasswordEncoderImpl;
import com.xhm.fz.dao.UserRoleRelationDao;
import com.xhm.fz.dto.UserParam;
import com.xhm.fz.entity.Role;
import com.xhm.fz.entity.User;
import com.xhm.fz.entity.UserExample;
import com.xhm.fz.entity.UserRoleRelation;
import com.xhm.fz.entity.UserRoleRelationExample;
import com.xhm.fz.mapper.UserMapper;
import com.xhm.fz.mapper.UserRoleRelationMapper;
import com.xhm.fz.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import cn.hutool.core.util.StrUtil;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    Md5PasswordEncoderImpl md5PasswordEncoderImpl;

    @Autowired
    UserRoleRelationDao userRoleRelationDao;
    @Autowired
    UserRoleRelationMapper userRoleRelationMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User getUserByUserName(String username) {
        // System.out.println("username1-----------" + username);
        User user = userMapper.selectByUserName(username);
        return user;
    }

    @Override
    public boolean checkLogin(String username, String rawPassword) throws Exception {
        // System.out.println("username-----------" + username);
        User user = this.getUserByUserName(username);
        // System.out.println("user = " + user);
        String encodePwd = DigestUtils.md5DigestAsHex(rawPassword.getBytes());
        if (user == null) {
            // System.out.println("checkLogin--------->账号不存在，请重新尝试！");
            // 设置友好提示
            throw new Exception("账号不存在，请重新尝试！");
        } else {
            // 加密的密码
            String encodedPassword = user.getPassword();
            // 和加密后的密码进行比配
            if (!encodedPassword.equals(encodePwd)) {
                // System.out.println("checkLogin--------->密码不正确！");
                // 设置友好提示
                throw new Exception("密码不正确！");
            } else {
                return true;
            }
        }
    }

    @Override
    public int updateUser(Integer id, UserParam userParam) {
        User rawUser = userMapper.selectByPrimaryKey(id);
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        user.setId(id);
        if (rawUser.getPassword().equals(user.getPassword())) {
            // 与原加密密码相同的不需要修改
            user.setPassword(null);
        } else {
            // 与原加密密码不同的需要加密修改
            if (StrUtil.isEmpty(user.getPassword())) {
                user.setPassword(null);
            } else {
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            }
        }
        return userMapper.updateByIdUser(user);
    }

    @Override
    public List<User> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andNicknameLike("%" + keyword + "%"));
        }
        return userMapper.selectByExample(example);
    }

    @Override
    public int update(Integer id, User user) {
        user.setId(id);
        User rawUser = userMapper.selectByPrimaryKey(id);
        if (rawUser.getPassword().equals(user.getPassword())) {
            // 与原加密密码相同的不需要修改
            user.setPassword(null);
        } else {
            // 与原加密密码不同的需要加密修改
            if (StrUtil.isEmpty(user.getPassword())) {
                user.setPassword(null);
            } else {
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            }
        }
        int count = userMapper.updateByPrimaryKeySelective(user);
        return count;
    }

    @Override
    public List<Role> getRoleList(Integer userId) {
        return userRoleRelationDao.getRoleList(userId);
    }

    @Override
    public int updateRole(Integer userId, List<Integer> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        // 先删除原来的关系
        UserRoleRelationExample userRoleRelationExample = new UserRoleRelationExample();
        userRoleRelationExample.createCriteria().andUidEqualTo(userId);
        userRoleRelationMapper.deleteByExample(userRoleRelationExample);
        // 建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UserRoleRelation> list = new ArrayList<>();
            for (Integer roleId : roleIds) {
                UserRoleRelation roleRelation = new UserRoleRelation();
                roleRelation.setUid(userId);
                roleRelation.setRid(roleId);
                list.add(roleRelation);
            }
            userRoleRelationDao.insertList(list);
        }
        return count;
    }

    @Override
    public int delete(List<Integer> ids) {
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(ids);
        int count = userMapper.deleteByExample(example);
        return count;
    }

    @Override
    public int register(UserParam userParam) {
        User user1 = userMapper.selectByUserName(userParam.getUsername());
        if (user1 != null) {
            return -1;
        }
        User user = new User();
        user.setUsername(userParam.getUsername());
        user.setNickname(userParam.getNickname());
        user.setPassword(userParam.getPassword());
        user.setPhone(userParam.getPhone());
        user.setEmail(userParam.getEmail());
        user.setSex(userParam.getSex());
        user.setRegTime(new Date());
        user.setState(1);
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> UserList = userMapper.selectByExample(example);
        if (UserList.size() > 0) {
            return 0;
        }
        String encodePassword = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(encodePassword);
        UserRoleRelation userRoleRelation = new UserRoleRelation();
        int count = userMapper.insert(user);
        if (count > 0) {
            userRoleRelation.setUid(user.getId());
            userRoleRelation.setRid(2);
            userRoleRelationMapper.insert(userRoleRelation);
            return count;
        }
        return 0;
    }

}
