package com.cubic.rest;

public enum ErrorType {

	GENERIC_ERROR(550), INVALID_DATA_ERROR(520), RECORD_NOT_FOUND(521), RECORD_ALREADY_EXIXTS(522);

	private int code;

	private ErrorType(final int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
