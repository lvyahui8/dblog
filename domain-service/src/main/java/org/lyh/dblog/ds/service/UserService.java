package org.lyh.dblog.ds.service;

import org.lyh.dblog.domain.User;
import org.lyh.dblog.ds.dao.IUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    public boolean save(User entity) {
        return false;
    }

    public List<User> select(Map<String, Object> conditions, String orderFiled, String sort, Integer offset, Integer size) {
        return null;
    }

    public User find(Integer id) {
        return null;
    }

    public List<User> all() {
        return this.userDao.all();
    }

}
