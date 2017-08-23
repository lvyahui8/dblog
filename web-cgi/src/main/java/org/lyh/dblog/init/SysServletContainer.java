package org.lyh.dblog.init;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.WebConfig;

import javax.servlet.ServletException;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2017/8/23 21:24
 */
public class SysServletContainer extends ServletContainer {
    @Override
    protected void init(WebConfig webConfig) throws ServletException {
        super.init(webConfig);
    }
}
