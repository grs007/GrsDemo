package com.grs.my.home.homemy;

import android.widget.LinearLayout;

import com.grs.my.R;
import com.grs.my.base.BaseFragment;

/**
 * Created by Administrator on 2017/8/3.
 */

public class HomeMyFragment extends BaseFragment<LinearLayout, HomeMy, HomeMyView, HomeMyPresenter> implements HomeMyView {
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_homemy;
    }

    @Override
    public HomeMyPresenter createPresenter() {
        return new HomeMyPresenter(mContext);
    }

    @Override
    public void setData(HomeMy data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        showError(new Exception("弄啥嘞"), false);
    }
}
