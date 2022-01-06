package com.github.rudysysu.springboot.mybatis.service.exception;

public enum ErrorCode {
	SUCCESS(0), ERROR(999);

	private int value;

	ErrorCode(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
