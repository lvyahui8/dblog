package org.lyh.dblog.init;

import org.glassfish.jersey.server.ResourceConfig;
import org.lyh.dblog.cgi.filter.RespFormatFilter;
import org.lyh.dblog.cgi.mapper.GloableExceptionMapper;

/**
 * jersey 配置
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2017/8/23 21:29
 */
public class BlogApplication  extends ResourceConfig{
    public BlogApplication() {
        packages("org.lyh.dblog.cgi.resource");
        // 统一异常处理

        register(GloableExceptionMapper.class);
        register(RespFormatFilter.class);

        // 将错误信息存在entity中作为响应
        //property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}
