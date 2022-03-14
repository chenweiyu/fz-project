package com.xhm.fz.service;

import javax.servlet.http.HttpServletRequest;

import com.xhm.fz.dto.OssCallbackResult;
// import com.xhm.fz.dto.OssCallbackResult;
import com.xhm.fz.dto.OssPolicyResult;

// import javax.servlet.http.HttpServletRequest;

/**
 * Oss对象存储管理Service
 * Created by xhm on 2018/5/17.
 */
public interface OssService {
    /**
     * Oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * Oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
