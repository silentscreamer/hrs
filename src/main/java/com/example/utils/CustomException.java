package com.example.utils;

import com.example.constants.ResultCode;

public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMessage;
	private ResultCode resultCode;
	private Long generatedObjectId;

	public CustomException(ResultCode resultCode) {
		this.errorCode = resultCode.getCode();
		this.errorMessage = resultCode.getMessage();
		this.resultCode = resultCode;
	}
	
	public CustomException(ResultCode resultCode, Exception exception) {
		super(exception);
		this.errorCode = resultCode.getCode();
		this.errorMessage = resultCode.getMessage();
		this.resultCode = resultCode;
	}
	
	public CustomException(Exception exception) {
		super(exception);
		this.errorCode = ResultCode.ERROR.getCode();
		this.errorMessage = ResultCode.ERROR.getMessage();
		this.resultCode = ResultCode.ERROR;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public Long getGeneratedObjectId() {
		return generatedObjectId;
	}

	public void setGeneratedObjectId(Long generatedObjectId) {
		this.generatedObjectId = generatedObjectId;
	}
}
