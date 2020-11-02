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
package com.pax.market.api.sdk.java.api.test;


import com.pax.market.trdsys.sdk.message.CloudMessageServiceApi;
import com.pax.market.trdsys.sdk.message.MsgType;
import com.pax.market.trdsys.sdk.message.dto.MsgContent;
import com.pax.market.trdsys.sdk.message.dto.Notification;
import com.pax.market.trdsys.sdk.message.dto.PushMessageCreateResultDto;
import com.pax.market.trdsys.sdk.message.dto.QueryArriveRateDto;
import com.pax.market.trdsys.sdk.message.request.MessageCreateRequest;
import com.pax.market.trdsys.sdk.message.result.Result;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;



/**
 *
 * @author tanjie
 * @date  2019/04/25 15:17:13
 */
public class TestMain {

	private CloudMessageServiceApi getMessageApi(){
		CloudMessageServiceApi api = new CloudMessageServiceApi(TestConstants.API_BASE_URL, TestConstants.API_KEY, TestConstants.API_SECRET);
		return api;
	}


	@Test
	public void testSendNotificationMsg(){
		MessageCreateRequest request = new MessageCreateRequest();
		request.setMsgType(MsgType.Notification);
		MsgContent msgContent = new MsgContent();
		Notification notification = new Notification();
		notification.setTitle("This is title of notification");
		notification.setContent("This is content of notification");
		msgContent.setNotification(notification);
		request.setContent(msgContent);
		request.setSerialNos(new String[]{"sn00001", "0820534734", "1170128227"});
		Result<PushMessageCreateResultDto> result = getMessageApi().createPushMessage(request);
		if(result.getData()!=null) {
			System.out.println(result);
		}
		Assert.assertNotNull(result.getData());
		Assert.assertEquals(result.getBusinessCode(), 0);
	}

	@Test
	public void testSendDataMsg(){
		MessageCreateRequest request = new MessageCreateRequest();
		request.setMsgType(MsgType.Data);
		MsgContent msgContent = new MsgContent();
		JSONObject data = new JSONObject();
		data.put("date", "12/7/2019");
		data.put("titile", "title");
		JSONObject addressNode = new JSONObject();
		addressNode.put("city", "jiangsu suzh");
		addressNode.put("postCode", "215000");
		data.put("address", addressNode);
		msgContent.setData(data);
		request.setContent(msgContent);
		request.setSerialNos(new String[]{"sn00001", "sn00002"});
		Result<PushMessageCreateResultDto> result = getMessageApi().createPushMessage(request);
		if(result.getData()!=null) {
			System.out.println(result.getData().getMsgIdentifier());
		}
		Assert.assertNotNull(result.getData());
		Assert.assertEquals(result.getBusinessCode(), 0);
	}

	@Test
	public void testSendMixTypeMsg(){
		MessageCreateRequest request = new MessageCreateRequest();
		request.setMsgType(MsgType.Mix);
		MsgContent msgContent = new MsgContent();
		Notification notification = new Notification();
		notification.setTitle("This is title of notification");
		notification.setContent("This is content of notification");
		msgContent.setNotification(notification);
		JSONObject data = new JSONObject();
		data.put("date", "12/7/2019");
		data.put("titile", "title");
		JSONObject addressNode = new JSONObject();
		addressNode.put("city", "jiangsu suzh");
		addressNode.put("postCode", "215000");
		data.put("address", addressNode);
		msgContent.setData(data);
		request.setContent(msgContent);
		request.setSerialNos(new String[]{"sn00001", "sn00002"});
		Result<PushMessageCreateResultDto> result = getMessageApi().createPushMessage(request);
		if(result.getData()!=null) {
			System.out.println(result.getData().getMsgIdentifier());
		}
		Assert.assertNotNull(result.getData());
		Assert.assertEquals(result.getBusinessCode(), 0);
	}

	@Test
	public void testSendMsg() throws InterruptedException {

		MessageCreateRequest request = new MessageCreateRequest();
//		String[] sn = {"abc","def", "1231231234","0820156379","SSY001","SN6144605","1150005520","SN8169082","1440000124","SSY003"};
//		String[] sn = {"0820843878","1700000262","0820156379","0820156380"};
//		String[] sn = {"1490000481"};
//		String[] sn = {"0820843878"};
//		String[] sn = {"CLOUD01000","CLOUD01001","CLOUD01002"};
		String[] sn = getSns();
//		System.out.println(sn);
		request.setSerialNos(sn);
		request.setMsgType(MsgType.Notification);

		MsgContent content = new MsgContent();
		Notification notification = new Notification();
		notification.setTitle("This is title of notification");
		notification.setContent("This is content of notification");

		content.setNotification(notification);
		JSONObject data = new JSONObject();
		data.put("name", "zhangsan");
		data.put("code", 1231);
		JSONObject node = new JSONObject();
		node.put("cc", "dd");
		node.put("xyz", "haha");
		data.put("mix", node);
		content.setData(data);
		request.setContent(content);
		Result<PushMessageCreateResultDto> result = getMessageApi().createPushMessage(request);


//		assertTrue(result.getBusinessCode() == 0);
//		for(int i=0;i<2000;i++) {
//			SendMsgThread thread = new SendMsgThread(api, request);
//			thread.start();
//		}
//		Thread.sleep(50000);

//		String content2 = "{\"notification\":{\"title\":\"测试\",\"content\":\"11111\"},\"data\":{\"code\":1231,\"name\":\"zhangsan\",\"mix\":{\"cc\":\"dd\",\"xyz\":\"haha\"}}}";
//		String result2 = CryptoUtils.aesEncrypt(content2, TestConstants.API_SECRET);
//		System.out.println(result2);

//		Result result2 = api.queryArriveRate("b8ddeca556dd4f25b1a1143a3f5e8855");
//		System.out.println(result2);
	}

	@Test
	public void testQueryArriveRate(){
		Result<QueryArriveRateDto> result = getMessageApi().queryArriveRate("b8ddeca556dd4f25b1a1143a3f5e8855");
		if(result.getBusinessCode() == 0) {
			System.out.println(result.getData().getArrivedNumber());
			System.out.println(result.getData().getArrivedRate());
		}
	}

	public static String[] getSns(){
		String[] result = new String[1000];
		for(int i=0;i<1000;i++){
			String suffix = i+"";
			if(suffix.length()==1) {
				suffix = "000"+suffix;
			}else if(suffix.length()==2){
				suffix = "00"+suffix;
			}else if(suffix.length()==3){
				suffix = "0"+suffix;
			}
			result[i] = "CLOUD0"+suffix;
		}
		return result;
	}

}
