package com.xhm.fz.dao;

import java.util.List;

import com.xhm.fz.entity.Role;
import com.xhm.fz.entity.UserRoleRelation;

import org.apache.ibatis.annotations.Param;

public interface UserRoleRelationDao {
    
    List<Role> getRoleList(@Param("userId") Integer userId);

    int insertList(@Param("list") List<UserRoleRelation> userRoleRelationList);
}
