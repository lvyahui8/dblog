package org.lyh.dblog.ds.service;

import org.lyh.dblog.domain.Post;
import org.lyh.dblog.ds.dao.ICategoryDao;
import org.lyh.dblog.ds.dao.IPostDao;
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

    public List<Post> select(Map<String, Object> conditions, String orderFiled, String sort, Integer offset, Integer size) {
        return postDao.select(conditions,orderFiled,sort,offset,size);
    }

    public Post find(Integer id) {
        return postDao.selectByPrimaryKey(id);
    }

    public void pullCnblogs(final Integer cnblogId){

    }
}
