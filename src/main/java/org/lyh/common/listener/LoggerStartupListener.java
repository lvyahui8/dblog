package org.lyh.common.listener;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import org.claret.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;

/**
 * @author lvyahui
 * @since 2016/9/13 20:56.
 */
public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {

    private boolean started = false;

    @Autowired
    private ServletContext servletContext;

    public void start() {
        if (started) return;
        /*
         * 如果rest层没有设置，该层的设置会生效
         */
        Context context = getContext();
        String workDir = context.getProperty("WORK_DIR");
        if(workDir == null){
            workDir = System.getProperty("WORK_DIR");
            if(workDir == null && servletContext != null){
                workDir = servletContext.getRealPath("/");
            }
            if(workDir == null){
                workDir = IOUtils.getRuntimePath();
            }
            context.putProperty("WORK_DIR",workDir);
        }
        started = true;
    }

    public void stop() {

    }

    public boolean isStarted() {
        return started;
    }

    public boolean isResetResistant() {
        return false;
    }

    public void onStart(LoggerContext context) {

    }

    public void onReset(LoggerContext context) {

    }

    public void onStop(LoggerContext context) {

    }

    public void onLevelChange(Logger logger, Level level) {

    }
}
