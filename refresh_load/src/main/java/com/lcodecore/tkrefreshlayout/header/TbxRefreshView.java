package com.lcodecore.tkrefreshlayout.header;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.OnAnimEndListener;
import com.lcodecore.tkrefreshlayout.R;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * Created by Administrator on 2017/7/4.
 */

public class TbxRefreshView extends FrameLayout implements IHeaderView {
    public TbxRefreshView(Context context) {
        this(context, null);
    }

    public TbxRefreshView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TbxRefreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private AnimationDrawable animationDrawable;
    private ImageView iv_refresh, loadingView;
    private AutoLinearLayout ll_refresh;
    private TextView tv_refresh;

    private void init() {
        View rootView = View.inflate(getContext(), R.layout.view_tbx, null);
        iv_refresh = (ImageView) rootView.findViewById(R.id.iv_tbx_arrow);
        ll_refresh = (AutoLinearLayout) rootView.findViewById(R.id.ll_tbx_arrow);
        tv_refresh = (TextView) rootView.findViewById(R.id.tv_tbx_arrow);
        loadingView = (ImageView) rootView.findViewById(R.id.iv_tbx_loading);
        loadingView.setImageResource(R.drawable.flush_gif);
        animationDrawable = (AnimationDrawable) loadingView.getDrawable();
        addView(rootView);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onPullingDown(float fraction, float maxHeadHeight, float headHeight) {
        if (fraction < 1f) {
            tv_refresh.setText("下拉刷新");
        } else if (fraction > 1f) {
            tv_refresh.setText("释放刷新");
        }
        iv_refresh.setRotation(fraction * headHeight / maxHeadHeight * 180);
    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {
        if (fraction < 1f) {
            tv_refresh.setText("下拉刷新");
            iv_refresh.setRotation(fraction * headHeight / maxHeadHeight * 180);
            if (ll_refresh.getVisibility() == GONE) {
                ll_refresh.setVisibility(VISIBLE);
                loadingView.setVisibility(GONE);
            }
        }
    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {
        ll_refresh.setVisibility(GONE);
        loadingView.setVisibility(VISIBLE);
        animationDrawable.start();
    }

    @Override
    public void onFinish(OnAnimEndListener animEndListener) {
        animEndListener.onAnimEnd();
    }

    @Override
    public void reset() {
        ll_refresh.setVisibility(VISIBLE);
        loadingView.setVisibility(GONE);
        tv_refresh.setText("下拉刷新");
    }
}
