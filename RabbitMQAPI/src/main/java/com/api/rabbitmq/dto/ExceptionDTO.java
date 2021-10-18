package com.api.rabbitmq.dto;

public class ExceptionDTO {
	
	public int httpStatus;
	public String msg;
	
	public ExceptionDTO(int httpStatus, String msg) {
		super();
		this.httpStatus = httpStatus;
		this.msg = msg;
	}

}
