package com.grs.my.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.grs.my.App;
import com.grs.my.BuildConfig;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Base class for Activities which has no logic
 *
 * @author Hannes Dorfmann
 */
public abstract class BaseActivityA<V extends MvpView, P extends MvpBasePresenter<V>> extends MvpActivity<V, P> {
    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().addActivity(this);
        init();
        initEvent();
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

    protected void initEvent() {

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        mUnBinder = ButterKnife.bind(this);
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
