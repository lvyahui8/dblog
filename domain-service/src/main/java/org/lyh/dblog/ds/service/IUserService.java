package org.lyh.dblog.ds.service;


import org.lyh.dblog.domain.User;

import java.util.List;

/**
 * Created by lvyahui on 2016/8/21.
 */
public interface IUserService {
    User getUserById(int userId);
    List<User> all();
}
