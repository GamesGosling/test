package com.xtkj.utils;

import java.io.Serializable;

/**
 * -对返回json对象进行包装的工具类
 * @author Administrator
 */
public class ObjectResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String msg;
	private Object result;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	public ObjectResult(String code, String msg, Object result) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
	}
	
	public ObjectResult(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
}
