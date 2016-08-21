package org.lyh.dblog.controller;

import org.lyh.dblog.entity.User;
import org.lyh.dblog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by lvyahui on 2016/8/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/view";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request,Model model){
        List<User> users = this.userService.all();
        model.addAttribute("users",users);
        return "user/list";
    }
}
