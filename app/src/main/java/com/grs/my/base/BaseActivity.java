package com.grs.my.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.grs.my.App;
import com.grs.my.BuildConfig;
import com.grs.my.R;
import com.grs.my.net.ResultException;
import com.grs.my.utils.NetUtil;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.net.UnknownHostException;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/1.
 */
public abstract class BaseActivity<CV extends View, M, V extends MvpLceView<M>, P extends MvpPresenter<V>>
        extends TMvpLceActivity<CV, M, V, P> {
    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().addActivity(this);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        mUnBinder = ButterKnife.bind(this);
        init();
        initEvent();
        loadData(false);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        if (name.equals(LAYOUT_FRAMELAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        }

        if (name.equals(LAYOUT_LINEARLAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        }

        if (name.equals(LAYOUT_RELATIVELAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }

        if (view != null) return view;
        return super.onCreateView(name, context, attrs);
    }

    protected void init() {

    }

    /**
     * 子类可以复写此方法初始化事件
     */
    protected void initEvent() {

    }

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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
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
