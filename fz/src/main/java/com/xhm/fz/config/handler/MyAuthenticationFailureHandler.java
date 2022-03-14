package com.xhm.fz.config.handler;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhm.fz.common.api.CommonResult;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * 登录失败操作
 */
@Component
public class MyAuthenticationFailureHandler extends JSONAuthentication implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {

        CommonResult<String> data = CommonResult.failed("登录失败:"+e.getMessage());
        //输出
        this.WriteJSON(request, response, data);
    }
}