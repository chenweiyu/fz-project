package com.xhm.fz.dto;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserParam {
    
    @ApiModelProperty(value = "用户名称",required = true)
    private String username;     //用户名

    @ApiModelProperty(value = "用户密码")
    private String password;     //密码

    @ApiModelProperty(value = "确认密码密码")
    private String checkPass;

    @ApiModelProperty(value = "用户昵称称")
    private String nickname;     //昵称

    @ApiModelProperty(value = "是否禁用")
    private boolean enabled;

    @ApiModelProperty(value = "用户电话")
    private String phone;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户性别")
    private String sex;

    @ApiModelProperty(value = "用户头像地址")
    private String userface;

    @ApiModelProperty(value = "用户状态")
    private Integer state;

    @ApiModelProperty(value = "用户注册时间")
    private Timestamp regTime; 
}
