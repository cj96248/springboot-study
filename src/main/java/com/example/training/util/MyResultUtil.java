package com.example.training.util;

import com.example.training.domain.MyResult;

public class MyResultUtil {
	
	public static MyResult<Object> success(){
		return success(null);
	}
	
	public static MyResult<Object> success(Object object){
		MyResult<Object> result = new MyResult<>();
		result.setCode(1);
		result.setMessage("Success");
		result.setData(object);
		return result;
	}
	
	public static MyResult<Object> failed(String message){
		MyResult<Object> result = new MyResult<>();
		result.setCode(1);
		result.setMessage(message);
		result.setData(null);
		return result;
	}
	
}
