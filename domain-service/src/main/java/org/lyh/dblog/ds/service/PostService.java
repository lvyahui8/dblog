package org.lyh.dblog.service.impl;

import org.lyh.dblog.dao.ICategoryDao;
import org.lyh.dblog.dao.IPostDao;
import org.lyh.dblog.entity.Post;
import org.lyh.dblog.service.IPostService;
import org.lyh.dblog.task.Task;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author samlv
 */
@Service("postService")
public class PostService implements IPostService {

    @Resource
    private IPostDao postDao;

    @Resource
    private ICategoryDao categoryDao;


    public boolean save(Post post) {
        return post.getId() == null ? postDao.insert(post) > 0 : postDao.updateByPrimaryKey(post) > 0;
    }


    public List<Post> select(Map<String, Object> conditionMap,
                             String orderFiled, String sort, Integer offset, Integer size) {
        List<Condition> conditions = new ArrayList<Condition>();
        for (Map.Entry<String,Object> item : conditionMap.entrySet()){
            conditions.add(new Condition(item.getKey(),"=",item.getValue()));
        }
        return postDao.select(conditions,orderFiled,sort,offset,size);
    }

    public Post find(Integer id) {
        return postDao.selectByPrimaryKey(id);
    }

    public void pullCnblogs(final Integer cnblogId){
        Task task = new Task(cnblogId) {
            @Override
            public void job() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(cnblogId);
            }
        };
        taskManager.execute(task);
    }
    public List<Post> all() {
        return null;
    }

}
