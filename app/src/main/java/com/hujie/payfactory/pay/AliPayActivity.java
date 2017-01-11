package com.hujie.payfactory.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.hujie.payfactory.MainActivity;
import com.hujie.payfactory.R;

import java.io.Serializable;

public class AliPayActivity extends AppCompatActivity implements Parcelable{

    public static void start(Context context,PayResult result){
        Intent intent=new Intent(context,AliPayActivity.class);
        intent.putExtra("result", (Serializable) result);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali_pay);
        PayResult payResultresult = getIntent().getParcelableExtra("result");
        String result = payResultresult.getResultStatus();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (TextUtils.equals("9000",result)){


            transaction.add(R.id.activity_main,new PaySuccessFragment());
            transaction.commit();

            transaction.add(R.id.activity_main,new PayFailFragment());
            transaction.commit();
        }

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
