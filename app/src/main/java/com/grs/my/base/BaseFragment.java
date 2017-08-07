package com.grs.my.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grs.my.App;
import com.grs.my.BuildConfig;
import com.grs.my.R;
import com.grs.my.net.ResultException;
import com.grs.my.utils.NetUtil;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.net.UnknownHostException;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<CV extends View, M, V extends MvpLceView<M>, P extends MvpPresenter<V>>
        extends TMvpLceFragment<CV, M, V, P> {

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
        loadData(false);
    }

    protected void init(){

    }

    /**
     * 子类可以复写此方法初始化事件
     */
    protected void initEvent() {

    }

    /**
     * 处理  errorMsg 内容
     *
     * @param e
     * @param pullToRefresh true Toast显示  false 错误页面展示
     * @return
     */
    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        if (!NetUtil.checkNetworkState(App.getContext()) || e instanceof UnknownHostException) {
            return getResources().getString(R.string.network_error);
        } else if (e instanceof ResultException) {
            return ((ResultException) e).msg;
        } else {
            return e.getMessage();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
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
