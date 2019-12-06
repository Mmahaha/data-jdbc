package com.example.datajdbc.mapper;


import com.example.datajdbc.bean.Task;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;


import java.util.*;

//@Mapper
public interface TaskMapper{
    //获取指定任务信息
    @Select("select * from task where taskId=#{taskId}")
    public Task getTaskInfo(Integer taskInfo);


    //此处为筛选集合
    //所有任务
    @Select("select taskId,userId,userName,category,title,description,tips,bounty,postAt,status from task order by ${sortBy} ${sort}")
    public List<LinkedHashMap<String,Object>> getAllTask(@Param("sortBy") String sortBy,@Param("sort") String sort);
    //所有中筛选任务
    @Select("select taskId,userId,userName,category,title,description,tips,bounty,postAt,status from task where category='${category}' order by ${sortBy} ${sort}")
    public List<LinkedHashMap<String,Object>> getAllTaskCategory(@Param("category") String category, @Param("sortBy") String sortBy,@Param("sort") String sort);

    //已接的全部任务
    @Select("select taskId,userId,userName,category,title,description,tips,bounty,postAt from task where status=1 order by ${sortBy} ${sort}")
    public List<LinkedHashMap<String,Object>> getAcceptTask(@Param("sortBy") String sortBy,@Param("sort") String sort);
    //已接中筛选任务
    @Select("select taskId,userId,userName,category,title,description,tips,bounty,postAt from task where status=1 and category='${category}' order by ${sortBy} ${sort}")
    public List<LinkedHashMap<String,Object>> getAcceptTaskCategory(@Param("category") String category,@Param("sortBy") String sortBy,@Param("sort") String sort);

    //可接的全部任务
    @Select("select taskId,userId,userName,category,title,description,tips,bounty,postAt from task where status=0 order by ${sortBy} ${sort}")
    public List<LinkedHashMap<String,Object>> getUnacceptedTask(@Param("sortBy") String sortBy,@Param("sort") String sort);
    //可接中筛选任务
    @Select("select taskId,userId,userName,category,title,description,tips,bounty,postAt from task where status=0 and category='${category}' order by ${sortBy} ${sort}")
    public List<LinkedHashMap<String,Object>> getUnacceptedTaskCategory(@Param("category") String category,@Param("sortBy") String sortBy,@Param("sort") String sort);




    //标记任务为已接
    @Update("update task set isAccept=1 ,refreshAt=now() where taskId = #{taskId}")
    public void setAccept(Integer taskId);

    //删除任务
    @Delete("delete from task where taskId=#{taskId}")
    public void deleteTask(Integer taskId);

    //发布任务
    @Options(useGeneratedKeys = true, keyProperty = "taskId")
    @Insert("insert into task(userId,userName,title,description,postAt,bounty,tips,category) values(#{userId},#{userName},#{title},#{description},now(),#{bounty},#{tips},#{category})")
    public void insertTask(Task task);

    //修改任务标题
    @Update("update task set title=#{title}, refreshAt=now() where taskId=#{taskId}")
    public void updateTitle(Integer taskId, String title);

    //任务信息修改
    @Update("update task set description=#{description},refreshAt=now() where taskId=#{taskId}")
    public void updateDescription(Integer taskId, String description);

    //获取指定用户的所有未接任务
    @Select("SELECT * FROM task WHERE  task.userId= #{userId} and task.status=0")
    public List<Task> getUnAcceptedTasksById(Integer userId);

    //获取指定用户的所有已接任务
    @Select("SELECT * FROM task WHERE  acceptBy=#{userId} and status=1")
    public List<Task> getAcceptedTasksById(Integer userId);

    //接受任务
    @Update("UPDATE task SET isAccept=1 ,acceptBy=#{userId}, acceptAt=NOW() WHERE taskId=#{taskId}")
    public void acceptTask(Integer taskId,Integer userId);

    //获取指定用户的所有已发布任务
    @Select("select * from task where userId=#{userId}")
    public  List<Task>  getReleasedTasksById(Integer userId);


}