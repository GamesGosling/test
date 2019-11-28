package com.xtkj.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用md5对数据进行加密处理。
 * @author Administrator
 */
public class Md5Encrypt {
	public static String md5(String str) {
		MessageDigest md;
		StringBuffer sb = new StringBuffer();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] data = md.digest();
			int index;
			for (byte b : data) {
				index = b;
				if (index < 0)
					index += 256;
				if (index < 16)
					sb.append("0");
				sb.append(Integer.toHexString(index));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}