package com.example.datajdbc.mapper;


import com.example.datajdbc.bean.Task;
import org.apache.ibatis.annotations.*;
import java.util.Date;
import java.text.SimpleDateFormat;


import java.util.List;

//@Mapper
public interface TaskMapper {


    @Select("select * from task")
    public List<Task> getAllTask();

    @Select("select * from task where isAccept=1")
    public List<Task> getAcceptTask();

    @Select("select * from task where isAccept=0")
    public List<Task> getUnacceptTask();

    @Update("update task set isAccept = 1 where taskId=#{taskId}")
    public void setAccept(Integer taskId);

    @Delete("delete from task where taskId=#{taskId}")
    public void deleteTask(Integer taskId);


    @Options(useGeneratedKeys = true, keyProperty = "taskId")
    @Insert("insert into task(userId,userName,title,description,postAt,bounty) values(#{userId},#{userName},#{title},#{description},now(),#{bounty})")
    public void insertTask(Task task);
}