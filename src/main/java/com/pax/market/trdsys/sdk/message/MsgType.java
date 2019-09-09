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
package com.pax.market.trdsys.sdk.message;

/**
 *
 * @author tanjie
 * @date  2019/05/05 14:09:38
 */
public enum MsgType {
	Notification(1),
	Data(2),
	Mix(3);
	private int val;
	private MsgType(int msgType) {
		this.val = msgType;
	}
	public int val() {
		return this.val;
	}
}
