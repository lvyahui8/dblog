package org.lyh.dblog.service;

import org.lyh.dblog.entity.User;

import java.util.List;

/**
 * Created by lvyahui on 2016/8/21.
 */
public interface IUserService {
    User getUserById(int userId);
    List<User> all();
}
