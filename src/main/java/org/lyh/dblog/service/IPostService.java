package org.lyh.dblog.service;

import org.lyh.dblog.entity.Post;

/**
 * @author samlv
 */
public interface IPostService {
    boolean save(Post post);
}
