package org.lyh.dblog.service;

import org.lyh.dblog.entity.User;

import java.util.List;

/**
 * Created by lvyahui on 2016/8/21.
 */
public interface IUserService {
    public User getUserById(int userId);
    public List<User> all();
}
