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

	private String rateLimit;
	private String rateLimitRemain;
	private String rateLimitReset;
	
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
		this.rateLimit = baseResponse.getRateLimit();
		this.rateLimitRemain = baseResponse.getRateLimitRemain();
		this.rateLimitReset = baseResponse.getRateLimitReset();
	}

	@Override
	public String toString() {
		return "Result{" +
				"businessCode=" + businessCode +
				", message='" + message + '\'' +
				", validationErrors=" + validationErrors +
				", data=" + data +
				", rateLimit='" + rateLimit + '\'' +
				", rateLimitRemain='" + rateLimitRemain + '\'' +
				", rateLimitReset='" + rateLimitReset + '\'' +
				'}';
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

	public String getRateLimit() {
		return rateLimit;
	}

	public void setRateLimit(String rateLimit) {
		this.rateLimit = rateLimit;
	}

	public String getRateLimitRemain() {
		return rateLimitRemain;
	}

	public void setRateLimitRemain(String rateLimitRemain) {
		this.rateLimitRemain = rateLimitRemain;
	}

	public String getRateLimitReset() {
		return rateLimitReset;
	}

	public void setRateLimitReset(String rateLimitReset) {
		this.rateLimitReset = rateLimitReset;
	}
}
