package org.lyh.dblog.cgi.resource;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author samlv
 */
public class BaseController {

    protected Logger logger = Logger.getLogger(this.getClass());

    protected Map<String,Object> makeData(int code, Map<String,Object> data){
        return makeData(code,data,null);
    }

    protected Map<String,Object> makeData(int code, Map<String,Object> data, String msg){
        Map<String,Object> jsonData = new HashMap<String, Object>();

        jsonData.put("code",code);
        jsonData.put("data",data);

        jsonData.put("msg",msg == null ? "" : msg);

        return jsonData;
    }
}
