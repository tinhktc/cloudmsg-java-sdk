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
package com.pax.market.trdsys.sdk.message.dto;

import java.io.Serializable;

/**
 *
 * @author tanjie
 * @date  2019/04/30 15:34:38
 */
public class QueryArriveRateDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8433121946416743854L;
	
	private Integer arrivedNumber;

    private String arrivedRate;

	public Integer getArrivedNumber() {
		return arrivedNumber;
	}

	public void setArrivedNumber(Integer arrivedNumber) {
		this.arrivedNumber = arrivedNumber;
	}

	public String getArrivedRate() {
		return arrivedRate;
	}

	public void setArrivedRate(String arrivedRate) {
		this.arrivedRate = arrivedRate;
	}

	@Override
	public String toString() {
		return "QueryArriveRateDto [arrivedNumber=" + arrivedNumber + ", arrivedRate=" + arrivedRate + "]";
	}

	
}
