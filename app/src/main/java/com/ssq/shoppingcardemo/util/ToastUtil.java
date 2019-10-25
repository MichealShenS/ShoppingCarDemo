package com.ssq.shoppingcardemo.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * Author : Mr.Shen
 * Date : 2019/10/23 15:27
 * Description : 下一个Toast覆盖上一个Toast,防止Toast弹出的时间过长
 */
public class ToastUtil {
    private static Toast mToast;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() {
        @Override
        public void run() {
            mToast.cancel();
        }
    };

    public static void makeText(Context mContext, String text) {
        mHandler.removeCallbacks(r);
        if (mToast != null) {
            mToast.setText(text);
        } else {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_LONG);
            mHandler.postDelayed(r, 2000);
            mToast.show();
        }
    }
}
