package com.example.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.constants.ResultCode;

@Component
public class ResultObject extends BaseDto {
	private static final long serialVersionUID = -8299137987711708619L;
	private boolean success;
	private ResultCode result;
	private String message;
	private Integer errorCode;
	private List<BaseDto> data = new ArrayList<>();

	public ResultObject() {
		this.success = false;
	}

	public ResultObject(boolean success, ResultCode result) {
		this.success = success;
		populateMessage(result);
	}

	private void populateMessage(ResultCode result) {
		this.result = result;
		this.message = result.getMessage();
		this.errorCode = result.getCode();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ResultCode getResult() {
		return result;
	}

	public void setResult(ResultCode result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public List<BaseDto> getData() {
		return data;
	}

	public void setData(List<BaseDto> data) {
		this.data = data;
	}
}
