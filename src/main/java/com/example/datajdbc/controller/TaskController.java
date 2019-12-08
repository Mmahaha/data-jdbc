package com.example.datajdbc.controller;


import com.example.datajdbc.bean.Task;
import com.example.datajdbc.mapper.TaskMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class TaskController {
    @Autowired
    TaskMapper taskMapper;

    //获取指定任务信息
    @GetMapping("/task/taskInfo/{taskid}")
    public Task getTaskInfo(@PathVariable("taskid") Integer taskid){return taskMapper.getTaskInfo(taskid);}


    /*
        ************筛选任务*******************
        status:三种状态:所有任务all/已接任务accepted/可接任务unaccepted
        category:具体分类名称
        sortBy:通过表内什么数据排序 bounty postAt等等
        sort:升序asc/降序desc
     */
    @GetMapping("/task/select")
    public Object selectTask(@Param("status") String status,@Param("category") String category,@Param("sort") String sort,@Param("sortBy") String sortBy){
        if(status.equals("all")){
            if(category.equals("all"))  return taskMapper.getAllTask(sortBy, sort);
            else    return taskMapper.getAllTaskCategory(category,sortBy,sort);
        }else if(status.equals("accepted")){
            if(category.equals("all")) return taskMapper.getAcceptTask(sortBy, sort);
            else return taskMapper.getAcceptTaskCategory(category,sortBy,sort);
        }else if(status.equals("unaccepted")){
            if(category.equals("all"))  return taskMapper.getUnacceptedTask(sortBy, sort);
            else    return taskMapper.getUnacceptedTaskCategory(category,sortBy,sort);
        }else{
            return "unknown command,check your param";
        }
    }


    //删除指定任务
    @GetMapping("/task/del/{taskid}")
    public Map<String,Object> delTask(@PathVariable("taskid") Integer taskid){
        taskMapper.deleteTask(taskid);
        Map<String,Object> res = new LinkedHashMap<>();
        res.put("status","success");
        return res;
    }

    //发布任务接口
    @PostMapping("/task/publish")
    public Map<String,Object> createTask(@RequestBody Task task){
        taskMapper.insertTask(task);
        Map res = new LinkedHashMap();
        res.put("status","success");
        res.put("taskId",task.getTaskId());
        return res;
    }

    //检查修改权限
    @GetMapping("task/checkStatus/{taskid}")
    public Object checkStatus(@PathVariable("taskid") Integer taskid) {
        Map<String,Object> res = new LinkedHashMap<>();
        if (taskMapper.getTaskInfo(taskid).getStatus().equals(0)){res.put("authority","enable");}
        else{res.put("authority","disable");}
        return res;
    }

    //修改任务信息
    @PostMapping("/task/updateTask")
    public Object  updateDescription(@RequestBody Task task){
        Map<String,Object> res = new LinkedHashMap<>();
        taskMapper.updateTask(task);
        res.put("status","success");
        return res;
    }


    //获取指定用户的所有未接任务
    @GetMapping("/task/getUnacceptedTasksById/{userId}")
    public  List<Task> getUnacceptedTasksById(@PathVariable ("userId") Integer userId) {
        List<Task> unAcceptedTasksById = taskMapper.getUnAcceptedTasksById(userId);
        return unAcceptedTasksById;
    }

    //获取指定用户的所有已接任务
    @GetMapping("/task/getAcceptedTasksById/{userId}")
    public  List<Task> getAcceptedTasksById(@PathVariable ("userId") Integer userId) {
        List<Task> AcceptedTasksById = taskMapper.getAcceptedTasksById(userId);
        return AcceptedTasksById;
    }

    //接受任务
    @PostMapping("/task/acceptTask")
    public Object acceptTask(@Param("taskId") Integer taskId,@Param("userId") Integer userId){
        Map<String,Object> res = new LinkedHashMap<>();
        if(taskMapper.getTaskInfo(taskId).getStatus().equals(1)){
            res.put("status","error");
            res.put("error_reason","Task has been accepted");
        }

        else{
            taskMapper.acceptTask(taskId, userId);
            if(taskMapper.getTaskInfo(taskId).getUserId().equals(userId)){
                res.put("status","error");
                res.put("error_reason","Can't accept your task");
            }
            else if(taskMapper.getTaskInfo(taskId).getStatus().equals(1)){
                res.put("status","success");
            }
            else{
                res.put("status","error");
                res.put("error_reason","unknown status");
            }

        }
        return res;
    }

    //完成任务
    @PostMapping("/task/finishTask")
    public Object finishTask(@Param("taskId") Integer taskId){
        Map<String,Object> res = new LinkedHashMap<>();
        if(taskMapper.getTaskInfo(taskId).getStatus().equals(1)){
            taskMapper.finishTask(taskId);
            res.put("status","success");
        }
        else{
            res.put("status","error");
            res.put("error_reason","Task has been finished or unaccepted");
        }
        return res;
    }

    //获取指定用户的所有已发布任务
    @GetMapping("/task/getReleasedTasksById/{userId}")
    public List<Task> getReleasedTasksById(@PathVariable("userId") Integer userId){
        return taskMapper.getReleasedTasksById(userId);
    }


}
