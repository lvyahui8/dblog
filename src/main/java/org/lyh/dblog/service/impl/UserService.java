package org.lyh.dblog.service.impl;

import org.lyh.dblog.dao.IUserDao;
import org.lyh.dblog.entity.User;
import org.lyh.dblog.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by lvyahui on 2016/8/21.
 */
@Service("userService")
public class UserService implements IUserService {

    @Resource
    private IUserDao userDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

    public List<User> all() {
        return this.userDao.all();
    }

}
