package org.lyh.dblog.task;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author lvyahui
 * @since 2016/9/4 22:26.
 */
public class TaskManager extends ThreadPoolTaskExecutor {
    private Set<Task> tasks = new LinkedHashSet<Task>();

    @Override
    public void execute(Runnable task) {
        Task mTask = (Task) task;
        synchronized (this){
            if(!tasks.contains(mTask)){
                tasks.add(mTask);
                mTask.setManager(this);
                super.execute(task);
            }
        }
    }

    public void remove(Task task) {
        synchronized (this){
            this.tasks.remove(task);
        }
    }
}
