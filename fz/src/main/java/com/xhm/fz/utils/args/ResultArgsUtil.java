package com.xhm.fz.utils.args;

/**
 * 返回参数
 * @Author xiumu
 * @Date 2020/5/28 10:09
 */
public class ResultArgsUtil {
    //登录验证失败
    public static String USER_NOT_EXIST_FAILURE_MSG = "账号或者密码错误";
    public static Integer USER_NOT_EXIST_FAILURE_CODE = 1004;

    //没有登录
    public static String USER_NOT_LOGIN_FAILURE_MSG = "未登录";
    public static Integer USER_NOT_LOGIN_FAILURE_CODE = 1002;

    //登录成功
    public static String USER_LOGIN_SUCCESS_MSG = "登录成功";
    public static Integer USER_LOGIN_SUCCESS_CODE = 1000;

    //无权限
    public static String AUTHORIZE_FAILURE_MSG = "没有权限";
    public static Integer AUTHORIZE_FAILURE_CODE = 1003;

    //注销成功
    public static String LOGOUT_SUCCESS_MSG = "注销成功";
    public static Integer LOGOUT_SUCCESS_CODE = 1005;

}
