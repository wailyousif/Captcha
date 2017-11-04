package com.app.dto;

/**
 * Created by wailm.yousif on 3/6/17.
 */

public class ResponseObject
{
    private boolean success;
    private int responseCode;
    private String responseString;

    public ResponseObject() { }
    
    public ResponseObject(boolean success, int responseCode, String responseString) {
		this.success = success;
		this.responseCode = responseCode;
		this.responseString = responseString;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }
}
