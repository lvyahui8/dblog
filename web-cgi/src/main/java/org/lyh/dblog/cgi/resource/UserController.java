package org.lyh.dblog.cgi.resource;

import org.lyh.dblog.domain.User;
import org.lyh.dblog.ds.service.UserService;
import org.lyh.dblog.msg.MsgCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 *
 * Created by lvyahui on 2016/8/21.
 */
@Path("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GET
    @Path("/view")
    @Produces("application/json")
    public Object view(@QueryParam("id") @NotNull(message = MsgCode.C_PARAM) Integer userId){
        logger.info("view :  " + userId);
        return this.userService.find(userId);
    }

    @GET
    @Path("/list")
    @Produces("application/json")
    public Object list(){
        List<User> users = this.userService.all();
        return users;
    }
}
