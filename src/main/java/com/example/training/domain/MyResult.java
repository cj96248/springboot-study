package com.example.training.domain;

public class MyResult<T> {
	
	/** status code */
	private Integer code;
	/** notice message */
	private String message;
	/** out put data */ 
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
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

	@Override
	public String toString() {
		return "MyResult [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
}
