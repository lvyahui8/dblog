package org.lyh.dblog.cgi.filter;


import net.sf.json.JSONObject;
import org.lyh.dblog.cgi.bean.SysException;
import org.lyh.dblog.cgi.bean.SystemResponse;
import org.lyh.dblog.msg.MsgCode;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2017/8/23 21:35
 */
public class RespFormatFilter implements ContainerResponseFilter,WriterInterceptor{
    /**
     * filter 在 aroundWriteTo 之前执行
     * */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

        /* 当resource上的方法return null时，默认响应的是204 no content，不会执行 aroundWriteTo */
        if (responseContext.getStatus() == 204) {
            responseContext.setStatus(200);
            SystemResponse response = new SystemResponse();
            response.setCode(MsgCode.C_SUCCESS);
            response.setData(JSONObject.fromObject(new JSONObject()));
            responseContext.setEntity(response);
        }

        /* 缺少必要请求参数 */
        if (responseContext.getStatus() == 400){
            throw new SysException(MsgCode.C_PARAM);
        }
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        Object entity = context.getEntity();
        if(! (entity instanceof SystemResponse)){
            SystemResponse response = new SystemResponse();
            response.setCode(MsgCode.C_SUCCESS);
            response.setMsg(MsgCode.getMsg(response.getCode()));
            response.setData(entity);
            entity = response;
        }
        context.getHeaders().putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8");
        context.setEntity(entity);
        context.proceed();
    }
}
