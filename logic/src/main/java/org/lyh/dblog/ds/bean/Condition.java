package org.lyh.dblog.ds.bean;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2016/12/12 13:27
 */
@SuppressWarnings("unused")
public class Condition {

    private String key;
    private String opt = "=";
    private Object value;

    public Condition(String key, String opt, Object value) {
        this.key = key;
        this.opt = opt;
        this.value = value;
    }

    public Condition(String key, Object value){
        this(key,"=",value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
