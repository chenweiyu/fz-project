package com.xhm.fz.service.impl;

// import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.xhm.fz.dto.OssCallbackParam;
import com.xhm.fz.dto.OssCallbackResult;
// import com.xhm.fz.dto.OssCallbackResult;
import com.xhm.fz.dto.OssPolicyResult;
import com.xhm.fz.service.OssService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.hutool.json.JSONUtil;

/**
 * Oss对象存储管理Service实现类
 * Created by xhm on 2018/5/17.
 */
@Service
public class OssServiceImpl implements OssService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OssServiceImpl.class);
	@Value("${aliyun.oss.policy.expire}")
	private int ALIYUN_OSS_EXPIRE;
	@Value("${aliyun.oss.maxSize}")
	private int ALIYUN_OSS_MAX_SIZE;
	@Value("${aliyun.oss.callback}")
	private String ALIYUN_OSS_CALLBACK;
	@Value("${aliyun.oss.bucketName}")
	private String ALIYUN_OSS_BUCKET_NAME;
	@Value("${aliyun.oss.endpoint}")
	private String ALIYUN_OSS_ENDPOINT;
	@Value("${aliyun.oss.dir.prefix}")
	private String ALIYUN_OSS_DIR_PREFIX;
	@Value("${aliyun.oss.accessKeyId}")
	private String ALIYUN_OSS_ACCESSKEYID;
	@Value("${aliyun.oss.accessKeySecret}")
	private String ALIYUN_OSS_ACCESSKEYSECRET;

	@Autowired(required=false)
	private OSSClient ossClient;

	/**
	 * 签名生成
	 */
	@Override
	public OssPolicyResult policy() {
		System.out.println("ALIYUN_OSS_EXPIRE: " + ALIYUN_OSS_EXPIRE);
		System.out.println("ALIYUN_OSS_MAX_SIZE: " + ALIYUN_OSS_MAX_SIZE);
		System.out.println("ALIYUN_OSS_CALLBACK: " + ALIYUN_OSS_CALLBACK);
		System.out.println("ALIYUN_OSS_BUCKET_NAME: " + ALIYUN_OSS_BUCKET_NAME);
		System.out.println("ALIYUN_OSS_ENDPOINT: " + ALIYUN_OSS_ENDPOINT);
		System.out.println("ALIYUN_OSS_DIR_PREFIX: " + ALIYUN_OSS_DIR_PREFIX);
		OssPolicyResult result = new OssPolicyResult();
		// 存储目录
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dir = ALIYUN_OSS_DIR_PREFIX + sdf.format(new Date()) + "/";
		// 签名有效期
		long expireEndTime = System.currentTimeMillis() + ALIYUN_OSS_EXPIRE * 1000;
		Date expiration = new Date(expireEndTime);
		// 文件大小
		long maxSize = ALIYUN_OSS_MAX_SIZE * 1024 * 1024;
		// 回调
		OssCallbackParam callback = new OssCallbackParam();
		callback.setCallbackUrl(ALIYUN_OSS_CALLBACK);
		callback.setCallbackBody("filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
		callback.setCallbackBodyType("application/x-www-form-urlencoded");
		// 提交节点
		String action = "https://" + ALIYUN_OSS_BUCKET_NAME + "." + ALIYUN_OSS_ENDPOINT;

		OSS ossClient = new OSSClientBuilder().build(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);
		try {
			PolicyConditions policyConds = new PolicyConditions();
			policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, maxSize);
			policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
			String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
			byte[] binaryData = postPolicy.getBytes("utf-8");
			String policy = BinaryUtil.toBase64String(binaryData);
			String signature = ossClient.calculatePostSignature(postPolicy);
			String callbackData = BinaryUtil.toBase64String(JSONUtil.parse(callback).toString().getBytes("utf-8"));
			// 返回结果
			result.setAccessKeyId(((OSSClient) ossClient).getCredentialsProvider().getCredentials().getAccessKeyId());
			result.setPolicy(policy);
			result.setSignature(signature);
			result.setDir(dir);
			result.setCallback(callbackData);
			result.setHost(action);
		} catch (Exception e) {
			LOGGER.error("签名生成失败", e);
		}
		return result;
	}

	@Override
	public OssCallbackResult callback(HttpServletRequest request) {
		OssCallbackResult result= new OssCallbackResult();
		String filename = request.getParameter("filename");
		filename = "http://".concat(ALIYUN_OSS_BUCKET_NAME).concat(".").concat(ALIYUN_OSS_ENDPOINT).concat("/").concat(filename);
		result.setFilename(filename);
		result.setSize(request.getParameter("size"));
		result.setMimeType(request.getParameter("mimeType"));
		result.setWidth(request.getParameter("width"));
		result.setHeight(request.getParameter("height"));
		return result;
	}

}
