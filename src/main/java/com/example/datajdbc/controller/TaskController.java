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

    @GetMapping("/task/unaccepted")
    public List<Task> getUnacceptTask(){return taskMapper.getUnacceptTask();}

    @GetMapping("/task/all")
    public List<Task> getAllTask(){return taskMapper.getAllTask();}

    @GetMapping("/task/accepted")
    public List<Task> getAcceptTask(){
        return taskMapper.getAcceptTask();
    }

    @PostMapping("/task/publish")
    public Map<String,Object> createTask(@RequestBody Task task){
        taskMapper.insertTask(task);
        Map ans = new HashMap();
        ans.put("status","success");
        ans.put("taskId",task.getTaskId());
        return ans;
    }
}
