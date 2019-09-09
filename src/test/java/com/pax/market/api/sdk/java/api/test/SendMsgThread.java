package com.pax.market.api.sdk.java.api.test;

import com.pax.market.trdsys.sdk.message.CloudMessageServiceApi;
import com.pax.market.trdsys.sdk.message.dto.PushMessageCreateResultDto;
import com.pax.market.trdsys.sdk.message.request.MessageCreateRequest;
import com.pax.market.trdsys.sdk.message.result.Result;

public class SendMsgThread extends Thread {

    private CloudMessageServiceApi api;
    private MessageCreateRequest request;
    public SendMsgThread(CloudMessageServiceApi api, MessageCreateRequest request) {
        this.api = api;
        this.request = request;
    }
    public void run() {
        Result<PushMessageCreateResultDto> result = api.createPushMessage(request);
//        if(result.getBusinessCode() == 0){
            System.out.println(result);
//        }

    }
}
