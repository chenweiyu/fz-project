package com.xhm.fz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OssTestController {

    @CrossOrigin
    @RequestMapping("/ossTest/policy")
    public Map<String, String> policy() {
        String accessId = "LTAI5t9eeRgji4pYeKQTkMP9"; // 请填写您的AccessKeyId。
        String accessKey = "K6Z5hMabzPXHxNMUBpjSCK5PtHOL57"; // 请填写您的AccessKeySecret。
        String endpoint = "oss-cn-shenzhen.aliyuncs.com"; // 请填写您的 endpoint。
        String bucket = "clothing-xhm"; // 请填写您的 bucketname 。
        String host = "https://" + bucket + "." + endpoint; // host的格式为 bucketname.endpoint
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        String dir = "clothing-test/" + date + "/"; // 用户上传文件时指定的前缀。

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);

        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            Map<String, String> respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            return respMap;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }
        return null;
    }

}
