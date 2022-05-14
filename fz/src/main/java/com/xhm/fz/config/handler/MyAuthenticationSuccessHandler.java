package com.xhm.fz.config.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.component.JwtTokenUtil;
import com.xhm.fz.component.TokenCache;
import com.xhm.fz.entity.User;
import com.xhm.fz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


/**
 * 登录成功操作
 */
@Component
public class MyAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {

    @Autowired
    UserService userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //取得账号信息
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //
        // System.out.println("userDetails = " + userDetails);
        //取token
        //好的解决方案，登录成功后token存储到数据库中
        //只要token还在过期内，不需要每次重新生成
        //先去缓存中找
        String token = TokenCache.getTokenFromCache(userDetails.getUsername());
        if(token ==null) {
            // System.out.println("初次登录，token还没有，生成新token。。。。。。");
            //如果token为空，则去创建一个新的token
            jwtTokenUtil = new JwtTokenUtil();
            token = jwtTokenUtil.generateToken(userDetails);
            //把新的token存储到缓存中
            TokenCache.setToken(userDetails.getUsername(),token);
        }

        // System.out.println("设置token:" + token);
        User user = userService.getUserByUserName(userDetails.getUsername());
        Map<String,Object> map = new HashMap<>();
        map.put("userId", user.getId());
        map.put("username", userDetails.getUsername());
        map.put("nickname", user.getNickname());
        map.put("userface", user.getUserface());
        map.put("phone", user.getPhone());
        map.put("email", user.getEmail());
        map.put("sex", user.getSex());
        map.put("auth", userDetails.getAuthorities());
        map.put("token", token);
        //装入token
        CommonResult<Map<String,Object>> data = CommonResult.success(map);
        //输出
        this.WriteJSON(request, response, data);

    }
}
