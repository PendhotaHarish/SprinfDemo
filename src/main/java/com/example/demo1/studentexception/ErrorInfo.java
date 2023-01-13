package com.example.demo1.studentexception;

public class ErrorInfo
{
    private int code;
    private String url;
    private String errorMsg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ErrorInfo(int code, String url, String errorMsg) {
        this.code = code;
        this.url = url;
        this.errorMsg = errorMsg;
    }
}
