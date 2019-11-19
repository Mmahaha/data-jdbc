package com.example.datajdbc.controller;


import com.example.datajdbc.bean.Task;
import com.example.datajdbc.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    @Autowired
    TaskMapper taskMapper;

    //查看所有未接任务
    @GetMapping("/task/unaccepted")
    public List<Task> getUnacceptTask(){return taskMapper.getUnacceptTask();}

    //查看所有任务
    @GetMapping("/task/all")
    public List<Task> getAllTask(){return taskMapper.getAllTask();}

    //查看所有已接任务
    @GetMapping("/task/accepted")
    public List<Task> getAcceptTask(){
        return taskMapper.getAcceptTask();
    }

    //删除指定任务
    @GetMapping("/task/del/{taskid}")
    public Map<String,Object> delTask(@PathVariable("taskid") Integer taskid){
        taskMapper.deleteTask(taskid);
        Map<String,Object> res = new HashMap<>();
        res.put("status","success");
        return res;
    }

    //发布任务接口
    @PostMapping("/task/publish")
    public Map<String,Object> createTask(@RequestBody Task task){
        taskMapper.insertTask(task);
        Map ans = new HashMap();
        ans.put("status","success");
        ans.put("taskId",task.getTaskId());
        return ans;
    }
}
