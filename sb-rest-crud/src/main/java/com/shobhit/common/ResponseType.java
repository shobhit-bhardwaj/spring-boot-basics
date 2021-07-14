package com.shobhit.common;

public enum ResponseType {
	SUCCESS (100, "SUCCESS"),
	INTERNAL_ERROR (101, "INTERNAL_ERROR");

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