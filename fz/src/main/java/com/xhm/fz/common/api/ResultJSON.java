package com.xhm.fz.common.api;

import lombok.Data;

/**
 * JSON返回信息
 * @Author xiumu
 * @Date 2020/5/18 16:30
 */
@Data
public class ResultJSON {
    /**
     * 返回的状态码 (待用).
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;


    /**
     * 返回的数据
     */
    private Object result;

    public ResultJSON() {
    }

    /**
     * 只返回状态码
     *
     * @param code 状态码
     */
    public ResultJSON(Integer code) {
        this.code = code;
    }

    /**
     * 不返回数据的构造方法
     *
     * @param code 状态码
     * @param msg  信息
     */
    public ResultJSON(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回数据的构造方法
     *
     * @param code   状态码
     * @param msg    信息
     * @param result 数据
     */
    public ResultJSON(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    /**
     * 返回状态码和数据
     *
     * @param code   状态码
     * @param result 数据
     */
    public ResultJSON(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }
}
