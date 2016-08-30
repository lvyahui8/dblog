package org.lyh.dblog.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author samlv
 */
@Intercepts({
        @Signature(type = StatementHandler.class,method = "prepare",args={Connection.class})
})
public class DBMonitorPlugin implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        Connection connection = (Connection) invocation.getArgs()[0];
        if(connection == null){
            // 记录连接失败
        }
        return invocation.proceed();
    }

    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    public void setProperties(Properties properties) {

    }
}
