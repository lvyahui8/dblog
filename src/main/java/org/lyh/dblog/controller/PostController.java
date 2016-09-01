package org.lyh.dblog.controller;

import org.lyh.dblog.entity.Post;
import org.lyh.dblog.service.IPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/save")
    public @ResponseBody Map<String,Object> save(Post post){
        Map<String,Object> data = new HashMap<String, Object>();
        int ret = 0;
        if(!postService.save(post)){
            ret = 1;
        }
        return makeData(ret,data);
    }

    @RequestMapping("/list")
    public @ResponseBody Map<String,Object> list(){

        return null;
    }

}
