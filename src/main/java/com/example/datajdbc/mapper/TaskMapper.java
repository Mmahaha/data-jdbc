package com.example.datajdbc.mapper;


import com.example.datajdbc.bean.Task;
import org.apache.ibatis.annotations.*;


import java.util.List;

//@Mapper
public interface TaskMapper {


    //获取所有任务
    @Select("select * from task")
    public List<Task> getAllTask();

    //获取已接任务
    @Select("select * from task where isAccept=1")
    public List<Task> getAcceptTask();

    //获取未接任务
    @Select("select * from task where isAccept=0")
    public List<Task> getUnacceptTask();

    //标记任务为已接
    @Update("update task set isAccept=1 ,refreshAt=now() where taskId = #{taskId}")
    public void setAccept(Integer taskId);

    //删除任务
    @Delete("delete from task where taskId=#{taskId}")
    public void deleteTask(Integer taskId);

    //发布任务
    @Options(useGeneratedKeys = true, keyProperty = "taskId")
    @Insert("insert into task(userId,userName,title,description,postAt,bounty) values(#{userId},#{userName},#{title},#{description},now(),#{bounty})")
    public void insertTask(Task task);

    //修改任务标题
    @Update("update task set title=#{title}, refreshAt=now() where taskId=#{taskId}")
    public void updateTitle(Integer taskId, String title);
}