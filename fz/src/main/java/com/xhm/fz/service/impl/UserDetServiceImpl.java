// package com.xhm.fz.service.impl;

// import com.xhm.fz.dto.UserParam;
// import com.xhm.fz.entity.UserDet;
// import com.xhm.fz.mapper.UserMapper;
// import com.xhm.fz.service.UserDetService;

// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class UserDetServiceImpl implements UserDetService{

//     @Autowired
//     UserMapper userMapper;

//     @Override
//     public int update(Long id, UserParam userParam) {
//         UserDet userDet = new UserDet();
//         userDet.setId(id);
//         BeanUtils.copyProperties(userParam, userDet);
//         return userMapper.updateByIdUser(userDet);
//     }
// }
