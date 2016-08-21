package org.lyh.dblog.service.impl;

import org.lyh.dblog.dao.IUserDao;
import org.lyh.dblog.entity.User;
import org.lyh.dblog.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * Created by lvyahui on 2016/8/21.
 */
@Service("userService")
public class UserService implements IUserService {

    @Resource
    private IUserDao IUserDao;

    public User getUserById(int userId) {
        return this.IUserDao.selectByPrimaryKey(userId);
    }
}
