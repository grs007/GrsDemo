package com.grs.my;

import android.content.Intent;
import android.os.Bundle;

import com.grs.my.base.BaseActivityN;
import com.grs.my.home.MainActivity;

/**
 * Created by Administrator on 2017/8/2.
 */

public class WelcomeActivity extends BaseActivityN {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }
}
