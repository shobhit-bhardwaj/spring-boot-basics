package com.shobhit.common;

public enum ResponseType {
	SUCCESS (100, "SUCCESS"),
	INTERNAL_ERROR (101, "INTERNAL_ERROR"),
	RECORD_NOT_FOUND (102, "RECORD_NOT_FOUND");

	private int responseCode;
	private String responseMessage;

	private ResponseType(int responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
}