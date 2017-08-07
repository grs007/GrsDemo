package com.grs.my.base;

import android.app.Activity;
import android.os.Bundle;

import com.grs.my.App;
import com.grs.my.BuildConfig;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 */

public class BaseActivityN extends AutoLayoutActivity {

    protected Activity mActivity;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        App.getInstance().addActivity(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        mUnBinder = ButterKnife.bind(this);
        init();
        initEvent();
    }

    protected void init() {

    }

    protected void initEvent() {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
    }


    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
