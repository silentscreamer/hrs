package com.example.constants;

public enum ResultCode {

	SUCCESS("Success", 0), 
	ERROR("Error", 1),
	SYSTEM_ERROR("A System Error Occured", 2),
	USER_ALREADY_EXISTS("A User with this email alreay exists.", 3),
	USER_DOES_NOT_EXIST("Specified User does not Exist", 4),
	ORGANIZATION_DOES_NOT_EXIST("Specified Organization does not Exist", 5),
	LEAVE_REQUESTED_SUCCESSFULLY("Leave request sent",6),
	LEAVE_DENIED("Your leave is denied",7),
	LEAVE_APPROAVED("Your leave is approved",8);

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
