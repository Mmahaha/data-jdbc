package com.example.datajdbc.mapper;

import com.example.datajdbc.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from _User where id=#{id}")
    public User getUserById(Integer id);

    @Delete("delete * from _User where id =#{id}")
    public int deleteUserById(Integer id);

    @Insert("insert into _User(userName,userPsd,userSex) values(#{userName},#{userPsd},#{userSex})")
    public
}
