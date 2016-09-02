package org.lyh.dblog.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author samlv
 */
public class ResultBody {
    private int code;
    private String msg;
    private Map<String,Object> data = new HashMap<String, Object>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
