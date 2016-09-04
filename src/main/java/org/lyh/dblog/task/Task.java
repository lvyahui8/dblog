package org.lyh.dblog.task;

/**
 * @author lvyahui
 * @since 2016/9/4 22:27.
 */
public abstract class Task implements Runnable{

    private Integer id;

    public Task(Integer id) {
        this.id = id;
    }


    TaskManager manager ;

    public void run() {
        job();
        if(this.manager != null){
            this.manager.remove(this);
        }
    }

    public void job(){

    }

    public void setManager(TaskManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id.equals(task.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
