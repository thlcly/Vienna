package com.vienna.utils;

import java.io.UnsupportedEncodingException;

import org.springframework.util.DigestUtils;

public class Md5Util {
	
	/**
	 * @author ys
	 * @createTime 2016年9月19日
	 * @description: 生成密文
	 */
	public static String sign(String text, String charset) throws Exception {
		return DigestUtils.md5DigestAsHex(getContentBytes(text, charset));
	}

	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("md5生成密码出错,您目前指定的编码集是:" + charset);
		}
	}
}
