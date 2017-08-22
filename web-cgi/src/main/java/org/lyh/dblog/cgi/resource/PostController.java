package org.lyh.dblog.cgi.resource;


import org.lyh.dblog.cgi.bean.ResultBody;
import org.lyh.dblog.domain.Post;
import org.lyh.dblog.ds.service.IPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author samlv
 */
@Controller
@RequestMapping("/post")
public class PostController extends BaseController {

    @Resource
    private IPostService postService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
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
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> list(@RequestParam  Map<String,Object> conditions){
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("posts",postService.select(conditions,"id","desc",0,3));
        return makeData(0,data);
    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    @ResponseBody
    public ResultBody view(@RequestParam  Integer id){
        ResultBody resp = new ResultBody();
        resp.setCode(0);
        resp.getData().put("post",postService.find(id));
        return resp;
    }

    @RequestMapping("/pull")
    @ResponseBody
    public ResultBody pull(@RequestParam  Integer cnblogId){
        ResultBody resp = new ResultBody();
        postService.pullCnblogs(cnblogId);
        return resp;
    }
}