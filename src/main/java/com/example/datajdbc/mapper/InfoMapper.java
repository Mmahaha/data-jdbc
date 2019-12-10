package com.example.datajdbc.mapper;

import com.example.datajdbc.bean.Info;
import org.apache.ibatis.annotations.*;

import java.util.*

public interface InfoMapper {
     /*
    Edited by 伟欢
    创建词条；
    修改词条；
     */

    @Options(useGeneratedKeys = true, keyProperty = "infoId")   //能够使自增的taskId返回数值
    @Insert("insert into info(userId,entry,content,creatAt) values(#{userId},#{entry},#{content},now())")
    public void creatInfo(Info info);

    @Select("select * from info")
    public List<Info> selectAllInfos();

    @Update("update info set entry=#{entry},content=#{content},refreshAt=now() where infoId=#{infoId}")
    public void updateInfo(Info info);




    /*
    Edited by 小棠
    展示词条列表(只要显示词条标题和词条id)；
    根据词条id获取具体信息；
     */
    //展示词条列表
    @Select("select infoId,entry from info")
    public List<Map>getAllInfo();
    //根据词条id获取具体信息
    @Select("select * from info where infoId=#{infoId}")
    public Info getInfoById(Integer infoId);



    /*
    Edited by 世杰
    删除词条 and more..
     */
}
