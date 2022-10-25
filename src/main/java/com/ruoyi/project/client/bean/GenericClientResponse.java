package com.ruoyi.project.client.bean;

/**
 * 功能描述
 *
 * @author: Sherlock
 * @date: 2022年10月20日 16:21
 */
public class GenericClientResponse<T> {

    private int status;
    private String message;
    private T data;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        if (this.status == 0) {
            return data;
        }
        else {
            throw new Error("系统未知错误");
        }
    }

    public void setData(T data) {
        this.data = data;
    }


}
