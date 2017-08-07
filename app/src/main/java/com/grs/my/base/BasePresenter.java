package com.grs.my.base;

import android.content.Context;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import rx.Subscriber;

public abstract class BasePresenter<V extends MvpLceView<M>, M>
        extends com.hannesdorfmann.mosby.mvp.MvpBasePresenter<V>
        implements com.hannesdorfmann.mosby.mvp.MvpPresenter<V> {

    protected Subscriber subscriber;
    protected Context context;

    public BasePresenter(Context context) {
        this.context = context;
    }

    /**
     * Unsubscribes the subscriber and set it to null
     */
    protected void unsubscribe() {
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
        subscriber = null;
        context = null;
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            unsubscribe();
        }
    }
}
