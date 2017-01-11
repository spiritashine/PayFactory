package com.hujie.payfactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hujie.payfactory.pay.PayFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PayFactory.createPay(PayFactory.TYPE_WX).pay(this,"");
        PayFactory.createPay(PayFactory.TYPE_AL).pay(this,"");

    }
}
