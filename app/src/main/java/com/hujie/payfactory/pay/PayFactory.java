package com.hujie.payfactory.pay;

/**
 * Created by hujie on 2017/1/11.
 */

public class PayFactory {
    public static final int TYPE_WX=0;
    public static final int TYPE_AL=1;

    public static IPay createPay(int type){
        switch (type){
            case TYPE_WX:
                return new WeChat();
            case TYPE_AL:
                return new ALi();
        }
        return null;
    }
}
