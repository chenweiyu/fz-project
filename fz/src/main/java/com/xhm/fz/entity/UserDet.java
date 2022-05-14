package com.xhm.fz.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDet {
    private Long id;             //主键
    private String username;     //用户名
    private String password;     //密码
    private String nickname;     //昵称
    private boolean enabled;     //是否禁用
    private String phone;
    private String email;        //邮箱
    private String sex;
    private String userface;     //头像
    private Timestamp regTime;   //注册时间
    private Integer state;
}
