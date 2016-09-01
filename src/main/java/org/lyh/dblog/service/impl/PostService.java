package org.lyh.dblog.service.impl;

import org.lyh.dblog.dao.ICategoryDao;
import org.lyh.dblog.dao.IPostDao;
import org.lyh.dblog.entity.Post;
import org.lyh.dblog.service.IPostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
