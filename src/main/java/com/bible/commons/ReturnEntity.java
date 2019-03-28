package com.bible.commons;

/**
 * 返回的实体类
 * @author xiuxiuzhang
 *
 */
public class ReturnEntity<T> {
	
	private String errorCode = ErrorCode.SUCCESS;
	private String message = "成功";
	private T data;
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	

}
