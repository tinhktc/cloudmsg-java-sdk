
import com.pax.market.trdsys.sdk.message.result.Result;
import com.pax.market.trdsys.sdk.message.dto.PushMessageCreateResultDto;
import org.json.JSONObject;
import com.pax.market.trdsys.sdk.message.dto.Notification;
import com.pax.market.trdsys.sdk.message.dto.MsgContent;
import com.pax.market.trdsys.sdk.message.MsgType;
import com.pax.market.trdsys.sdk.message.request.MessageCreateRequest;
import com.pax.market.trdsys.sdk.message.CloudMessageServiceApi;

// 
// Decompiled by Procyon v0.5.36
// 

public class CloudMessage
{
    public static void main(final String[] args) {
    	// prod
//        final String appKey = "8RJTFLJCGZ6CDXYRAR0G";
//        final String apiSecret = "Z721MZYPAPD557MJS0HPU7OA3PQA9ZGP6DAJMSV1";
    	// ctest
        final String appKey = "LINM1RTCT7SM3R3I1ANR";
        final String apiSecret = "N977PMNQS1RQRZSWCRY8GHTT3YFGZSU9FQJ5JGIQ";
        final CloudMessageServiceApi api = new CloudMessageServiceApi("https://api.whatspos.com/p-market-api", appKey, apiSecret);
        final MessageCreateRequest request = new MessageCreateRequest();
        request.setMsgType(MsgType.Data);
        final MsgContent msgContent = new MsgContent();
        final Notification notification = new Notification();
        msgContent.setNotification(notification);
        final String str_data = "{ title:" + args[1] + ", content:" + args[2] + "," + args[3] + "}";
        System.out.println(str_data);
        System.out.println("appKey: " + appKey + " apiSecret: " + apiSecret);
        JSONObject data = new JSONObject();
        data = createJSONObject(str_data);
        msgContent.setData(data);
        request.setContent(msgContent);
        request.setSerialNos(new String[] { args[0] });
        final Result<PushMessageCreateResultDto> result = (Result<PushMessageCreateResultDto>)api.createPushMessage(request);
        if (result.getData() != null) {
            System.out.println("MsgIdentifier: " + ((PushMessageCreateResultDto)result.getData()).getMsgIdentifier());
        }
    }
    
    private static JSONObject createJSONObject(final String jsonString) {
        return new JSONObject(jsonString);
    }
}