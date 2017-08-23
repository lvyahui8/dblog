package org.lyh.dblog.cgi.resource;


import org.lyh.dblog.cgi.bean.ResultBody;
import org.lyh.dblog.domain.Post;
import org.lyh.dblog.ds.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * @author samlv
 */
@Path("/post")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @POST
    @Path("/save")
    @Consumes("application/json")
    @Produces("application/json")
    public @ResponseBody Map<String,Object> save(Post post){
        Map<String,Object> data = new HashMap<String, Object>();
        int ret = 0;
        if(!postService.save(post)){
            ret = 1;
        }
        return makeData(ret,data);
    }

    /**
     *
     * {"data":{"posts":[{"id":1,"title":"标题",
     * "createdAt":1472738566000,"updatedAt":1472738566000,"content":"内容"}]},"code":0,"msg":""}
     * @param conditions 输入条件
     * @return json数据
     */
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody Map<String,Object> list(@RequestParam  Map<String,Object> conditions){
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("posts",postService.select(conditions,"id","desc",0,3));
        return makeData(0,data);
    }

    @GET
    @Path("/view")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultBody view(@RequestParam  Integer id){
        ResultBody resp = new ResultBody();
        resp.setCode(0);
        resp.getData().put("post",postService.find(id));
        return resp;
    }

}
