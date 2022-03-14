package com.xhm.fz.dao;

import com.xhm.fz.entity.AdminRoleRelation;
import com.xhm.fz.entity.Resource;
import com.xhm.fz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色关系管理自定义Dao
 * Created by xhm on 2018/10/8.
 */
public interface AdminRoleRelationDao {
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<AdminRoleRelation> adminRoleRelationList);

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
