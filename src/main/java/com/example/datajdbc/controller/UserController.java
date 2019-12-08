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

    //获取所有用户列表
    @GetMapping("/user/alluser")
    public List<User> getalluser(){
        return userMapper.getAllUser();
    }

    //获取指定用户信息
    @GetMapping("/user/inquire/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userMapper.getUserById(id);
    }

    //用户注册接口
    @PostMapping("/user/register")
    public Object createUser(@RequestBody User user){
        userMapper.insertUser(user);
        return user;
    }

    //删除指定用户
    @GetMapping("/user/del/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userMapper.deleteUserById(id);
        return "success";
    }

    //判断是否新用户
    @GetMapping("/user/judge/{openid}")
    public Object judge(@PathVariable("openid") String openid){
        Map<String,Object> res = new HashMap<>();
        if(userMapper.judge(openid)==null)
            {res.put("status","unexisted");
            return res;}
        else
            return userMapper.judge(openid);
    }

    //按信用度排序用户
    @GetMapping("/user/rank")
    public Object userRank(){return userMapper.userRank();}
}
