package com.sjm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjm.domain.User;
import com.sjm.service.UserService;
import com.sjm.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Message login(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session){
        int userId = userService.findUser(username,password);
        session.setAttribute("userId", userId);
        return Message.success();
    }

    @RequestMapping(value="/user",method = RequestMethod.POST)
    public Message saveUser(User user){
        userService.saveUser(user);
        return Message.success();
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public Message getUsers(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam(value="username",defaultValue="")String username
    		,@RequestParam(value="email",defaultValue="")String email){
        PageHelper.startPage(pn,5);
        List<User> users = userService.getUsers(username,email);
        PageInfo<?> pageInfo = new PageInfo<>(users,5);
        return Message.success().add("pageInfo",pageInfo);
    }


    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public Message getUser(@PathVariable("id")Integer id){
        User user = userService.getUserById(id);
        return  Message.success().add("user",user);
    }

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.PUT)
    public Message updateUser(User user){
        userService.updateUser(user);
        return Message.success();
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public Message deleteUser(@PathVariable("id")Integer id){
    	userService.deleteUser(id);
        return Message.success();
    }
    
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public Message updateUser(@RequestParam("oldPwd")String oldPwd , @RequestParam("newPwd")String newPwd , HttpSession session){
    	int userId = (int)session.getAttribute("userId");
        userService.updatePwd(oldPwd,newPwd,userId);
        return Message.success();
    }

}
