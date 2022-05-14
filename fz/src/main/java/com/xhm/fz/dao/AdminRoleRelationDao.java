package com.xhm.fz.dao;

import com.xhm.fz.entity.UserRoleRelation;
import com.xhm.fz.entity.Resource;
import com.xhm.fz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleRelationDao {
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UserRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     */
    List<Role> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有可访问资源
     */
    List<Resource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
