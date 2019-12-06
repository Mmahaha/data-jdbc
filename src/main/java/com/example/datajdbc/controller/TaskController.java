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
        Map ans = new LinkedHashMap();
        ans.put("status","success");
        ans.put("taskId",task.getTaskId());
        return ans;
    }

    //修改任务描述
    @PostMapping("/task/updateDescription")
    public Object  updateDescription(@Param("taskId") Integer taskId,@Param ("description")String description){
        taskMapper.updateDescription(taskId,description);
        Map<String,Object> res = new LinkedHashMap<>();
        if(taskMapper.getTaskInfo(taskId).getDescription().equals(description))
            res.put("status","success");
        else {
            res.put("status","error");
            res.put("error_reason","check your params");
        }
        return res;
    }

    //修改任务标题
    @PostMapping("/task/updateTitle")
    public Object updateTitle(@Param("taskId") Integer taskId, @Param("title")String title){
        taskMapper.updateTitle(taskId,title);
        Map<String,Object> res = new LinkedHashMap<>();
        if(taskMapper.getTaskInfo(taskId).getTitle().equals(title))
            res.put("status","success");
        else{
            res.put("status","error");
            res.put("error_reason","check your params");
        }

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
        if(taskMapper.getTaskInfo(taskId).getStatus()==1){
            res.put("status","error");
            res.put("error_reason","Task has been accepted");
        }

        else{
            taskMapper.acceptTask(taskId, userId);
            if(taskMapper.getTaskInfo(taskId).getStatus()==1){
                res.put("status","success");
            }
            else{
                res.put("status","error");
                res.put("error_reason","unknown");
            }

        }

        return res;
    }

    //获取指定用户的所有已发布任务
    @GetMapping("/task/getReleasedTasksById/{userId}")
    public List<Task> getReleasedTasksById(@PathVariable("userId") Integer userId){
        return taskMapper.getReleasedTasksById(userId);
    }


}
