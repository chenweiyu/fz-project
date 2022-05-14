package com.xhm.fz.service.impl;

import com.github.pagehelper.PageHelper;
// import com.xhm.fz.dao.RoleDao;
import com.xhm.fz.mapper.RoleMapper;
// import com.xhm.fz.mapper.RoleMenuRelationMapper;
// import com.xhm.fz.mapper.RoleResourceRelationMapper;
import com.xhm.fz.entity.*;
// import com.xhm.fz.service.AdminCacheService;
import com.xhm.fz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    // @Autowired
    // private RoleMenuRelationMapper roleMenuRelationMapper;
    // @Autowired
    // private RoleResourceRelationMapper roleResourceRelationMapper;
    // @Autowired
    // private RoleDao roleDao;
    // @Autowired
    // private AdminCacheService adminCacheService;
    // @Override
    public int create(Role role) {
        role.setCreateTime(new Date());
        return roleMapper.insert(role);
    }

    @Override
    public int update(Integer id, Role role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(List<Integer> ids) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIdIn(ids);
        int count = roleMapper.deleteByExample(example);
        return count;
    }

    @Override
    public List<Role> list() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public List<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        RoleExample example = new RoleExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(example);
    }

    // @Override
    // public List<Menu> getMenuList(Long adminId) {
    //     return roleDao.getMenuList(adminId);
    // }

    // @Override
    // public List<Menu> listMenu(Long roleId) {
    //     return roleDao.getMenuListByRoleId(roleId);
    // }

    // @Override
    // public List<Resource> listResource(Long roleId) {
    //     return roleDao.getResourceListByRoleId(roleId);
    // }

    // @Override
    // public int allocMenu(Long roleId, List<Long> menuIds) {
    //     //先删除原有关系
    //     RoleMenuRelationExample example=new RoleMenuRelationExample();
    //     example.createCriteria().andRoleIdEqualTo(roleId);
    //     roleMenuRelationMapper.deleteByExample(example);
    //     //批量插入新关系
    //     for (Long menuId : menuIds) {
    //         RoleMenuRelation relation = new RoleMenuRelation();
    //         relation.setRoleId(roleId);
    //         relation.setMenuId(menuId);
    //         roleMenuRelationMapper.insert(relation);
    //     }
    //     return menuIds.size();
    // }

    // @Override
    // public int allocResource(Long roleId, List<Long> resourceIds) {
    //     //先删除原有关系
    //     RoleResourceRelationExample example=new RoleResourceRelationExample();
    //     example.createCriteria().andRoleIdEqualTo(roleId);
    //     roleResourceRelationMapper.deleteByExample(example);
    //     //批量插入新关系
    //     for (Long resourceId : resourceIds) {
    //         RoleResourceRelation relation = new RoleResourceRelation();
    //         relation.setRoleId(roleId);
    //         relation.setResourceId(resourceId);
    //         roleResourceRelationMapper.insert(relation);
    //     }
    //     // adminCacheService.delResourceListByRole(roleId);
    //     return resourceIds.size();
    // }
}
