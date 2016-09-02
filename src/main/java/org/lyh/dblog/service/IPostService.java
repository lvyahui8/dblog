package org.lyh.dblog.service;

import org.lyh.dblog.entity.Post;

import java.util.List;
import java.util.Map;

/**
 * @author samlv
 */
public interface IPostService {
    boolean save(Post post);

    List<Post> select(Map<String,Object> conditions, String orderFiled, String sort, Integer offset, Integer size);

    Post find(Integer id);
}
