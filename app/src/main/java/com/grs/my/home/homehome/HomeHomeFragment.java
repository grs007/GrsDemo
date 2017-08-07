package com.grs.my.home.homehome;

import android.os.Handler;
import android.widget.LinearLayout;

import com.grs.my.R;
import com.grs.my.base.BaseFragment;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/3.
 */

public class HomeHomeFragment extends BaseFragment<LinearLayout, HomeHome, HomeHomeView, HomeHomePresenter> implements HomeHomeView {
    @BindView(R.id.autotrack_refresh)
    TwinklingRefreshLayout refreshLayout;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_autotrack;
    }

    @Override
    public HomeHomePresenter createPresenter() {
        return new HomeHomePresenter(mContext);
    }

    @Override
    protected void init() {
        SinaRefreshView headerView = new SinaRefreshView(mContext);
        LoadingView bottomView = new LoadingView(mContext);
        refreshLayout.setHeaderView(headerView);
        refreshLayout.setBottomView(bottomView);
        refreshLayout.setMaxHeadHeight(AutoUtils.getPercentWidthSize(140));
        refreshLayout.setOverScrollBottomShow(false);
        refreshLayout.setAutoLoadMore(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData(true);
                        refreshLayout.setEnableLoadmore(true);
                        refreshLayout.finishRefreshing();
                    }
                }, 1500);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData(true);
                        refreshLayout.finishLoadmore();
                    }
                }, 1500);
            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void setData(HomeHome data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        showContent();
    }
}
