package com.grs.my.net;

/**
 * Created by Administrator on 2017/3/14.
 */

public class ResultException extends RuntimeException {
    public String msg;
    public int code;

    public ResultException(String msg) {
        this.msg = msg;
    }

    public ResultException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
