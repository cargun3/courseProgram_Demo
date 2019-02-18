package com.example.demo.domain;

import io.swagger.annotations.ApiModelProperty;

public class ResponseVO<T> {
	
	@ApiModelProperty(value="�ڵ�")
	private int code = 200;
	@ApiModelProperty(value="�޼���")
	private String message;
	@ApiModelProperty(value="��������")
	private boolean check = true;
	@ApiModelProperty(value="json ������")
	private T response;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "ResponseVO [code=" + code + ", message=" + message + ", check=" + check + ", response=" + response
				+ "]";
	}
}
