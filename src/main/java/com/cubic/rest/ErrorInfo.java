package com.cubic.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorInfo {

	private String errorCode;
	private String errorDesc;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

}
