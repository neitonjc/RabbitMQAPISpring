package com.api.rabbitmq.dto;

public class ExceptionDTO {
	
	private int httpStatus;
	private String msg;
	
	public ExceptionDTO(int httpStatus, String msg) {
		super();
		this.httpStatus = httpStatus;
		this.msg = msg;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public String getMsg() {
		return msg;
	}

}
