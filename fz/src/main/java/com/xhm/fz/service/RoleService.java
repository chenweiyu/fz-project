package com.xhm.fz.service;

import com.xhm.fz.entity.Resource;
import com.xhm.fz.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface RoleService {
    /**
     * 添加角色
     */
    int create(Role role);

    /**
     * 修改角色信息
     */
    int update(Integer id, Role role);

    /**
     * 批量删除角色
     */
    int delete(List<Integer> ids);

    /**
     * 获取所有角色列表
     */
    List<Role> list();

    /**
     * 分页获取角色列表
     */
    List<Role> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 获取角色相关资源
     */
    // List<Resource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    // @Transactional
    // int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    // @Transactional
    // int allocResource(Long roleId, List<Long> resourceIds);
}
