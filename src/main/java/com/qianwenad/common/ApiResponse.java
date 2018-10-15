package com.qianwenad.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {
	private static final long serialVersionUID = 7592428766762196851L;

	private int code;
	private String msg;
	private T data;

	public ApiResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ApiResponse(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ApiResponse(ResponseCode responseCode) {
		this.code = responseCode.getCode();
		this.msg = responseCode.getMessage();
	}

	public ApiResponse(ResponseCode responseCode, T data) {
		this.code = responseCode.getCode();
		this.msg = responseCode.getMessage();
		this.data = data;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public static ApiResponse response(ResponseCode responseCode) {
		return response(responseCode.getCode(), responseCode.getMessage());
	}

	public static ApiResponse response(ResponseCode responseCode, Object... holders) {
		return response(responseCode.getCode(), responseCode.getMessage(holders));
	}

	public static ApiResponse response(int code, String message) {
		ApiResponse response = new ApiResponse(code, message);
		return response;
	}

	public static <T> ApiResponse ok(T data) {
		ApiResponse response = new ApiResponse(ResponseCode.SUCCESS, data);
		return response;
	}

	public static ApiResponse ok() {
		return ok(null);
	}

}
