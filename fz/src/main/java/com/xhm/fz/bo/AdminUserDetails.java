package com.xhm.fz.bo;

import com.xhm.fz.entity.Admin;
import com.xhm.fz.entity.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * Created by xhm on 2018/4/26.
 */
public class AdminUserDetails implements UserDetails {
    //后台用户
    private Admin Admin;
    //拥有资源列表
    private List<Resource> resourceList;
    public AdminUserDetails(Admin Admin,List<Resource> resourceList) {
        this.Admin = Admin;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return Admin.getPassword();
    }

    @Override
    public String getUsername() {
        return Admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Admin.getStatus().equals(1);
    }
}