package com.grs.my.net;

/**
 * Created by turbo on 2017/3/9.
 */


import com.grs.my.App;
import com.grs.my.utils.NetUtil;

import java.net.UnknownHostException;

import rx.Subscriber;

/**
 * 封装Subscriber
 */
public abstract class RxSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (!NetUtil.checkNetworkState(App.getContext()) || e instanceof UnknownHostException) {
            _onError(e, "网络不可用!");
        } else if (e instanceof ResultException) {
            onResultError(e, ((ResultException) e).code, ((ResultException) e).msg);
        } else
            _onError(e, e.getMessage());
    }


    public void onLoad() {

    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    public abstract void _onNext(T t);

    public void onResultError(Throwable e, int code, String msg) {
        _onError(e, msg);
    }

    public abstract void _onError(Throwable e, String msg);
}