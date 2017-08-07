package com.grs.my.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

;

public class ToastUtil {
    private static Toast mToast;

    public static void show(Context context, String content) {
        if (mToast != null) {
            mToast.setText(content);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.BOTTOM, 0, 50);
        } else {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.BOTTOM, 0, 50);
        }
        mToast.show();
    }

    public static void show(Context context, int contentId) {
        Toast.makeText(context, contentId, Toast.LENGTH_SHORT).show();
    }
}