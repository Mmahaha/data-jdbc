package com.example.datajdbc.mapper;


import com.example.datajdbc.bean.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface TaskMapper {
    @Select("select * from task")
    public List<Task> getAllTask();

    @Select("select * from task where isAccept=1")
    public List<Task> getAcceptTask();

    @Update("update task set isAccept = 1 where taskId={taskId}")
    public void setAccept(Integer taskId);

    @Delete("delete from task where taskId={taskId}")
    public void deleteTask(Integer taskId);

    //@Insert("insert into ")
}
