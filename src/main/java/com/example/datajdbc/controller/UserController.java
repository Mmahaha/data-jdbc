package com.example.datajdbc.controller;


import com.example.datajdbc.bean.User;
import com.example.datajdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/alluser")
    public List<User> getalluser(){
        return userMapper.getAllUser();
    }

    @GetMapping("/user/inquire/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userMapper.getUserById(id);
    }

    @PostMapping("/user/register")
    public Object createUser(@RequestBody User user){
        userMapper.insertUser(user);
        return user;
    }

    @GetMapping("/user/del/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userMapper.deleteUserById(id);
        return "success";
    }

    @GetMapping("/user/judge/{openid}")
    public Object judge(@PathVariable("openid") String openid){
        Map<String,Object> res = new HashMap<>();
        if(userMapper.judge(openid)==null)
            {res.put("status","unexisted");
            return res;}
        else
            return userMapper.judge(openid);
    }
}
