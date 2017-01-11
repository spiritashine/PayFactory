package com.hujie.payfactory.pay;

import android.app.Activity;
import android.content.Context;

import com.hujie.payfactory.MainActivity;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hujie on 2017/1/11.
 */

public class WeChat implements IPay {
    @Override
    public void pay(Activity context, String info) {
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(context, "appID");
        iwxapi.registerApp("appID");
        try {

            JSONObject jsonObject=new JSONObject(info);
            PayReq request = new PayReq();
            request.appId = "wxd930ea5d5a258f4f";
            request.partnerId = "1900000109";
            request.prepayId= "1101000000140415649af9fc314aa427";
            request.packageValue = "Sign=WXPay";
            request.nonceStr= "1101000000140429eb40476f8896f4c9";
            request.timeStamp= "1398746574";
            request.sign= "7FFECB600D7157C5AA49810D2D8F28BC2811827B";
            iwxapi.sendReq(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
