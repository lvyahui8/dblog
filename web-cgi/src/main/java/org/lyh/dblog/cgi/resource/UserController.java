package org.lyh.dblog.cgi.resource;

import org.lyh.dblog.domain.User;
import org.lyh.dblog.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * Created by lvyahui on 2016/8/21.
 */
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/view")
    public Object view(Integer userId){
        logger.info("view :  " + userId);
        return this.userService.find(userId);
    }

    @RequestMapping("/list")
    public List<User> list(){
        return this.userService.all();
    }
}
