// package com.xhm.fz.service.impl;

// // import javax.servlet.http.HttpServletRequest;
// // import java.util.ArrayList;
// // import java.util.Date;
// import java.util.List;

// // import cn.hutool.core.collection.CollUtil;
// // import cn.hutool.core.util.StrUtil;
// // import com.github.pagehelper.PageHelper;
// import com.xhm.fz.bo.AdminUserDetails;
// import com.xhm.fz.common.exception.Asserts;
// // import com.xhm.fz.common.util.RequestUtil;
// import com.xhm.fz.dao.AdminRoleRelationDao;
// // import com.xhm.fz.mapper.AdminRoleRelationMapper;
// import com.xhm.fz.entity.Admin;
// import com.xhm.fz.entity.AdminExample;
// import com.xhm.fz.entity.Resource;
// // import com.xhm.fz.dto.AdminParam;
// // import com.xhm.fz.dto.UpdateAdminPasswordParam;
// // import com.xhm.fz.mapper.AdminLoginLogMapper;
// import com.xhm.fz.mapper.AdminMapper;
// // import com.xhm.fz.service.AdminCacheService;
// import com.xhm.fz.service.AdminService;
// import com.xhm.fz.utils.JwtTokenUtil;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// // import org.springframework.beans.BeanUtils;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Lazy;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// // import org.springframework.util.CollectionUtils;
// // import org.springframework.util.StringUtils;
// // import org.springframework.web.context.request.RequestContextHolder;
// // import org.springframework.web.context.request.ServletRequestAttributes;

// /**
//  * 后台用户管理Service实现类
//  * Created by xhm on 2018/4/26.
//  */
// @Service
// public class AdminServiceImpl implements AdminService {
//     private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
//     @Autowired
//     private JwtTokenUtil jwtTokenUtil;
//     @Lazy
//     @Autowired
//     private PasswordEncoder passwordEncoder;
//     @Autowired
//     private AdminMapper adminMapper;
//     // @Autowired
//     // private AdminRoleRelationMapper adminRoleRelationMapper;
//     @Autowired
//     private AdminRoleRelationDao adminRoleRelationDao;
//     // @Autowired
//     // private AdminLoginLogMapper loginLogMapper;
//     // @Autowired
//     // private AdminCacheService adminCacheService;

//     @Override
//     public Admin getAdminByUsername(String username) {
//         // Admin admin = adminCacheService.getAdmin(username);
//         // if(admin!=null) return  admin;
//         Admin admin;
//         AdminExample example = new AdminExample();
//         example.createCriteria().andUsernameEqualTo(username);
//         List<Admin> adminList = adminMapper.selectByExample(example);
//         if (adminList != null && adminList.size() > 0) {
//             admin = adminList.get(0);
//             // adminCacheService.setAdmin(admin);
//             return admin;
//         }
//         return null;
//     }

//     // @Override
//     // public Admin register(AdminParam AdminParam) {
//     //     Admin Admin = new Admin();
//     //     BeanUtils.copyProperties(AdminParam, Admin);
//     //     Admin.setCreateTime(new Date());
//     //     Admin.setStatus(1);
//     //     //查询是否有相同用户名的用户
//     //     AdminExample example = new AdminExample();
//     //     example.createCriteria().andUsernameEqualTo(Admin.getUsername());
//     //     List<Admin> AdminList = adminMapper.selectByExample(example);
//     //     if (AdminList.size() > 0) {
//     //         return null;
//     //     }
//     //     //将密码进行加密操作
//     //     String encodePassword = passwordEncoder.encode(Admin.getPassword());
//     //     Admin.setPassword(encodePassword);
//     //     adminMapper.insert(Admin);
//     //     return Admin;
//     // }

//     @Override
//     public String login(String username, String password) {
//         String token = null;
//         //密码需要客户端加密后传递
//         try {
//             UserDetails userDetails = loadUserByUsername(username);
//             if(!passwordEncoder.matches(password,userDetails.getPassword())){
//                 Asserts.fail("密码不正确");
//             }
//             if(!userDetails.isEnabled()){
//                 Asserts.fail("帐号已被禁用");
//             }
//             UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//             SecurityContextHolder.getContext().setAuthentication(authentication);
//             token = jwtTokenUtil.generateToken(userDetails);
// //            updateLoginTimeByUsername(username);
//             // insertLoginLog(username);
//         } catch (AuthenticationException e) {
//             LOGGER.warn("登录异常:{}", e.getMessage());
//         }
//         return token;
//     }

//     /**
//      * 添加登录记录
//      * @param username 用户名
//      */
//     // private void insertLoginLog(String username) {
//     //     Admin admin = getAdminByUsername(username);
//     //     if(admin==null) return;
//     //     AdminLoginLog loginLog = new AdminLoginLog();
//     //     loginLog.setAdminId(admin.getId());
//     //     loginLog.setCreateTime(new Date());
//     //     ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//     //     HttpServletRequest request = attributes.getRequest();
//     //     loginLog.setIp(RequestUtil.getRequestIp(request));
//     //     loginLogMapper.insert(loginLog);
//     // }

//     /**
//      * 根据用户名修改登录时间
//      */
//     // private void updateLoginTimeByUsername(String username) {
//     //     Admin record = new Admin();
//     //     record.setLoginTime(new Date());
//     //     AdminExample example = new AdminExample();
//     //     example.createCriteria().andUsernameEqualTo(username);
//     //     adminMapper.updateByExampleSelective(record, example);
//     // }

//     // @Override
//     // public String refreshToken(String oldToken) {
//     //     return jwtTokenUtil.refreshHeadToken(oldToken);
//     // }

//     // @Override
//     // public Admin getItem(Long id) {
//     //     return adminMapper.selectByPrimaryKey(id);
//     // }

//     // @Override
//     // public List<Admin> list(String keyword, Integer pageSize, Integer pageNum) {
//     //     PageHelper.startPage(pageNum, pageSize);
//     //     AdminExample example = new AdminExample();
//     //     AdminExample.Criteria criteria = example.createCriteria();
//     //     if (!StringUtils.isEmpty(keyword)) {
//     //         criteria.andUsernameLike("%" + keyword + "%");
//     //         example.or(example.createCriteria().andNickNameLike("%" + keyword + "%"));
//     //     }
//     //     return adminMapper.selectByExample(example);
//     // }

//     // @Override
//     // public int update(Long id, Admin admin) {
//     //     admin.setId(id);
//     //     Admin rawAdmin = adminMapper.selectByPrimaryKey(id);
//     //     if(rawAdmin.getPassword().equals(admin.getPassword())){
//     //         //与原加密密码相同的不需要修改
//     //         admin.setPassword(null);
//     //     }else{
//     //         //与原加密密码不同的需要加密修改
//     //         if(StrUtil.isEmpty(admin.getPassword())){
//     //             admin.setPassword(null);
//     //         }else{
//     //             admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//     //         }
//     //     }
//     //     int count = adminMapper.updateByPrimaryKeySelective(admin);
//     //     adminCacheService.delAdmin(id);
//     //     return count;
//     // }

//     // @Override
//     // public int delete(Long id) {
//     //     adminCacheService.delAdmin(id);
//     //     int count = adminMapper.deleteByPrimaryKey(id);
//     //     adminCacheService.delResourceList(id);
//     //     return count;
//     // }

//     // @Override
//     // public int updateRole(Long adminId, List<Long> roleIds) {
//     //     int count = roleIds == null ? 0 : roleIds.size();
//     //     //先删除原来的关系
//     //     AdminRoleRelationExample adminRoleRelationExample = new AdminRoleRelationExample();
//     //     adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
//     //     adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
//     //     //建立新关系
//     //     if (!CollectionUtils.isEmpty(roleIds)) {
//     //         List<AdminRoleRelation> list = new ArrayList<>();
//     //         for (Long roleId : roleIds) {
//     //             AdminRoleRelation roleRelation = new AdminRoleRelation();
//     //             roleRelation.setAdminId(adminId);
//     //             roleRelation.setRoleId(roleId);
//     //             list.add(roleRelation);
//     //         }
//     //         adminRoleRelationDao.insertList(list);
//     //     }
//     //     adminCacheService.delResourceList(adminId);
//     //     return count;
//     // }

//     // @Override
//     // public List<Role> getRoleList(Long adminId) {
//     //     return adminRoleRelationDao.getRoleList(adminId);
//     // }

//     @Override
//     public List<Resource> getResourceList(Long adminId) {
//         // List<Resource> resourceList = adminCacheService.getResourceList(adminId);
//         // if(CollUtil.isNotEmpty(resourceList)){
//         //     return  resourceList;
//         // }
//         List<Resource> resourceList;
//         resourceList = adminRoleRelationDao.getResourceList(adminId);
//         // if(CollUtil.isNotEmpty(resourceList)){
//         //     adminCacheService.setResourceList(adminId,resourceList);
//         // }
//         return resourceList;
//     }

//     // @Override
//     // public int updatePassword(UpdateAdminPasswordParam param) {
//     //     if(StrUtil.isEmpty(param.getUsername())
//     //             ||StrUtil.isEmpty(param.getOldPassword())
//     //             ||StrUtil.isEmpty(param.getNewPassword())){
//     //         return -1;
//     //     }
//     //     AdminExample example = new AdminExample();
//     //     example.createCriteria().andUsernameEqualTo(param.getUsername());
//     //     List<Admin> adminList = adminMapper.selectByExample(example);
//     //     if(CollUtil.isEmpty(adminList)){
//     //         return -2;
//     //     }
//     //     Admin Admin = adminList.get(0);
//     //     if(!passwordEncoder.matches(param.getOldPassword(),Admin.getPassword())){
//     //         return -3;
//     //     }
//     //     Admin.setPassword(passwordEncoder.encode(param.getNewPassword()));
//     //     adminMapper.updateByPrimaryKey(Admin);
//     //     adminCacheService.delAdmin(Admin.getId());
//     //     return 1;
//     // }

//     @Override
//     public UserDetails loadUserByUsername(String username){
//         //获取用户信息
//         Admin admin = getAdminByUsername(username);
//         if (admin != null) {
//             List<Resource> resourceList = getResourceList(admin.getId());
//             return new AdminUserDetails(admin,resourceList);
//         }
//         throw new UsernameNotFoundException("用户名或密码错误");
//     }
// }
