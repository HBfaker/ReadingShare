package edu.bupt.config;

/**
 * Created by 73681 on 2018/6/23.
 */
public class ErrorInfo<T> {
    public static final Integer OK = 200;
    public static final Integer ERROR = 1000;
    public static final Integer NeedLoginERROR = 900;

    private Integer code;
    private String msg;
    private String url;
    private T data;


    public static Integer getOK() {
        return OK;
    }

    public static Integer getERROR() {
        return ERROR;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
