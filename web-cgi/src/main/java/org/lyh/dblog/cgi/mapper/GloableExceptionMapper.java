package org.lyh.dblog.cgi.mapper;

import org.glassfish.jersey.server.ParamException;
import org.lyh.dblog.cgi.bean.SysException;
import org.lyh.dblog.cgi.bean.SystemResponse;
import org.lyh.dblog.msg.MsgCode;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2017/8/23 21:31
 */
public class GloableExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        SystemResponse response = new SystemResponse();

        if (exception instanceof SysException){
            response.setCode(exception.getMessage());
        } else {
            if (exception instanceof NotFoundException || exception instanceof NotAllowedException
                    || exception instanceof NotSupportedException){
                response.setCode(MsgCode.C_404);
            }
            else if (exception instanceof ParamException){
                response.setCode(MsgCode.C_PARAM);
            }
            else {
                response.setCode(MsgCode.C_UNKOWN_ERROR);
            }

            response.setMsg(response.getMsg() + " [" + exception.getCause().getLocalizedMessage() + "]") ;
        }


        return Response.status(Response.Status.OK)
                .entity(response)
                .header("Content-Type",MediaType.APPLICATION_JSON + "; charset=utf-8")
                .type(MediaType.APPLICATION_JSON).build();
    }
}
