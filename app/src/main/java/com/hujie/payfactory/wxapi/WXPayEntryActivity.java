package com.hujie.payfactory.wxapi;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hujie.payfactory.MainActivity;
import com.hujie.payfactory.R;
import com.hujie.payfactory.pay.PayFailFragment;
import com.hujie.payfactory.pay.PaySuccessFragment;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpay_entry);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
            int code=baseResp.errCode;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (code){
            //成功
            case 0:
                transaction.add(R.id.activity_main,new PaySuccessFragment());
                transaction.commit();
                break;
            //失败
            case 1:
                transaction.add(R.id.activity_main,new PayFailFragment());
                transaction.commit();
                break;
            //取消
            case 2:
                break;
        }
    }
}
