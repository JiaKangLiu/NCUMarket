package com.newMedia.dto;

public class DoResult<T> {
    private boolean success;
    private T data;
    private String error;

//返回数据

    //返回正确
    public DoResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

//    返回失败

    public DoResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
