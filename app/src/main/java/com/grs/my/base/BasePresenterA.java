package com.grs.my.base;

import android.content.Context;

import com.grs.my.net.RxSubscriber;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2017/3/14.
 */

public class BasePresenterA<V extends MvpView> extends MvpBasePresenter<V> implements MvpPresenter<V> {

    protected RxSubscriber subscriber;
    protected Context context;

    public BasePresenterA(Context context) {
        this.context = context;
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance && subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
        subscriber = null;
        context = null;
    }
}
