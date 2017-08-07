package com.grs.my.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grs.my.BuildConfig;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragmentN extends Fragment {

    protected Context mContext;
    protected View mRootView;
    private Unbinder mUnbinder;

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    public void onAttach(Activity activity) {
        mContext = activity;
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        mContext = null;
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //todo 对rootview判空会造成异常，后续查看原因 参考http://blog.csdn.net/yaolingrui/article/details/7339913
        mRootView = inflater.inflate(getLayoutRes(), container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.setDebug(BuildConfig.DEBUG);
        mUnbinder = ButterKnife.bind(this, view);
        init();
        initEvent();
    }

    protected void init() {

    }

    protected void initEvent() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //todo https://github.com/JakeWharton/butterknife/issues/390
//        mUnbinder.unbind();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
