package org.lyh.dblog.cgi.resource;


import org.lyh.dblog.domain.Post;
import org.lyh.dblog.ds.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author samlv
 */
@RestController
@RequestMapping("/post")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> save(Post post){
        Map<String,Object> data = new HashMap<String, Object>();
        int ret = 0;
        if(!postService.save(post)){
            ret = 1;
        }
        return data;
    }

    /**
     *
     * {"data":{"posts":[{"id":1,"title":"标题",
     * "createdAt":1472738566000,"updatedAt":1472738566000,"content":"内容"}]},"code":0,"msg":""}
     * @param conditions 输入条件
     * @return json数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String,Object> list(@RequestParam  Map<String,Object> conditions){
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("posts",postService.select(conditions,"id","desc",0,3));
        return data;
    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public Post view(@RequestParam Integer id){
        return postService.find(id);
    }

}
