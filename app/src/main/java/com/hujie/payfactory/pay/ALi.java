package com.hujie.payfactory.pay;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.PayTask;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hujie on 2017/1/11.
 */

public class ALi implements IPay {
    Context context;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                PayResult result=new PayResult((HashMap<String, String>)msg.obj);
                AliPayActivity.start(context,result);
            }
        }
    };



    @Override
    public void pay(final Activity context, final String info) {
        final String orderInfo = info;   // 订单信息
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(context);
                Map<String, String> result = alipay.payV2(info, true);

                Message obtain = Message.obtain();
                obtain.what=1;
                obtain.obj=result.get("result");
                handler.sendMessage(obtain);


            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
