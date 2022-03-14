package com.xhm.fz.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xhm
 * @Date 2020/5/19 17:16
 */
@Data
public class User implements UserDetails {
    private Long id;             //主键
    private String username;     //用户名
    private String password;     //密码
    private String nickname;     //昵称
    private boolean enabled;     //是否禁用
    private List<Role> roles;    //用户角色
    private String email;        //邮箱
    private String userface;     //头像
    private Timestamp regTime;   //注册时间
    private Integer state;

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "User{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", nickname='" + getNickname() + "'" +
            ", enabled='" + isEnabled() + "'" +
            ", roles='" + getRoles() + "'" +
            ", email='" + getEmail() + "'" +
            ", userface='" + getUserface() + "'" +
            ", regTime='" + getRegTime() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }
    

}
