package com.xhm.fz.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.xhm.fz.common.api.ResultJSON;

import cn.hutool.json.JSONUtil;

/**
 * @Author xhm
 * @Date 2020/5/29 14:40
 */
public class SecurityHandlerUtil {
    /**
     * security处理返回结果
     * @param response 响应
     * @param result 结果
     * @throws IOException
     */
    public static void responseHandler(HttpServletResponse response, ResultJSON result) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        PrintWriter writer = response.getWriter();
        writer.write(JSONUtil.toJsonStr(result));
        writer.flush();
        writer.close();
    }
}
