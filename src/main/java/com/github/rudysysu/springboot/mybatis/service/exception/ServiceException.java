package com.github.rudysysu.springboot.mybatis.service.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 6893674062825521877L;

	private ErrorCode errorCode = ErrorCode.ERROR;

	public ErrorCode getErrorCode() {
		return this.errorCode;
	}

	public int getErrorCodeValue() {
		return this.errorCode.getValue();
	}

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(ErrorCode erroCode) {
		super();
		this.errorCode = erroCode;
	}

	public ServiceException(ErrorCode erroCode, String message) {
		super(message);
		this.errorCode = erroCode;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(ErrorCode erroCode, Throwable cause) {
		super(cause);
		this.errorCode = erroCode;
	}
}
