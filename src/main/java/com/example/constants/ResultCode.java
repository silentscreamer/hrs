package com.example.constants;

public enum ResultCode {

	SUCCESS("Success", 0), ERROR("Error", 1);

	private String message;
	private Integer code;

	ResultCode(String message, Integer code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
