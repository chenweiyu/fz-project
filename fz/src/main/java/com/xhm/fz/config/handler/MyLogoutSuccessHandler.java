package com.xhm.fz.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhm.fz.common.api.CommonResult;

import java.io.IOException;

/**
 * 成功退出处理器
 */
@Component
public class MyLogoutSuccessHandler extends JSONAuthentication implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
//        UserDetails user = (UserDetails) authentication.getPrincipal();
//        String username = user.getUsername();
        CommonResult<String> data = CommonResult.success("退出成功");
        super.WriteJSON(request,response,data);
    }
}
