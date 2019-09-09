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
 * @date  2019/04/30 16:13:00
 */
public class PushMessageCreateResultDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8893371613168031639L;
	
	private String msgIdentifier;

	public String getMsgIdentifier() {
		return msgIdentifier;
	}

	public void setMsgIdentifier(String msgIdentifier) {
		this.msgIdentifier = msgIdentifier;
	}
}
