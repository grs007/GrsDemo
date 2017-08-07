package com.grs.my.bean;

/**
 * Created by Administrator on 2017/3/14.
 */

public class HttpResult<T> {
    private int code;
    private String descb;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
