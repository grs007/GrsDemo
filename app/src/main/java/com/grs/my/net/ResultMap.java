package com.grs.my.net;


import com.grs.my.bean.HttpResult;

import rx.functions.Func1;

/**
 * Created by Administrator on 2017/4/14.
 */

public class ResultMap<T> implements Func1<HttpResult<T>, T> {
    @Override
    public T call(HttpResult<T> tHttpResult) {
        if (tHttpResult.getCode() == 200) {
            return tHttpResult.getData();
        } else {
            throw new ResultException(tHttpResult.getCode(), tHttpResult.getDescb());
        }
    }
}
