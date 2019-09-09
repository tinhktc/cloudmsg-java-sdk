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

import org.json.JSONObject;

import java.io.Serializable;

/**
 *
 * @author tanjie
 * @date  2019/05/05 14:25:15
 */
public class MsgContent implements Serializable{

	private static final long serialVersionUID = 1069767980539421643L;
	
	private Notification notification;
	
	private String data;

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public String getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data==null?null:data.toString();
	}
	
}
