/*
 * *******************************************************************************
 * COPYRIGHT
 *               PAX TECHNOLOGY, Inc. PROPRIETARY INFORMATION
 *   This software is supplied under the terms of a license agreement or
 *   nondisclosure agreement with PAX  Technology, Inc. and may not be copied
 *   or disclosed except in accordance with the terms in that agreement.
 *
 *      Copyright (C) 2017 PAX Technology, Inc. All rights reserved.
 * *******************************************************************************
 */
package com.pax.market.trdsys.sdk.message.result;

import java.io.Serializable;
import java.util.List;

import com.pax.market.trdsys.sdk.message.response.BaseResponse;

/**
 *
 * @author tanjie
 * @date  2019/04/30 14:09:07
 */
public class Result <T extends Serializable> implements Serializable{
	
	private int businessCode;
	private String message;
	private List<String> validationErrors;
	private T data;
	
	public Result() {
		
	}
	
	public Result(List<String> errors) {
		this.businessCode = -1;
		this.validationErrors = errors;
	}
	
	public Result(BaseResponse baseResponse, T data) {
		this.businessCode = baseResponse.getBusinessCode();
		this.message = baseResponse.getMessage();
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [businessCode=" + businessCode + ", message=" + message + ", validationErrors="
				+ validationErrors + ", data=" + data + "]";
	}

	public int getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(int businessCode) {
		this.businessCode = businessCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
	

}
