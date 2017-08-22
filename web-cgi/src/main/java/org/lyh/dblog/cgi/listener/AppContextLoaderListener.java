package org.lyh.dblog.cgi.listener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author lvyahui
 * @since 2016/9/13 19:56.
 */
public class AppContextLoaderListener extends ContextLoaderListener {
    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        /*
        * 设置环境变量
        * */
        System.setProperty("WORKDIR",servletContext.getRealPath("/"));
        return super.initWebApplicationContext(servletContext);
    }
}
