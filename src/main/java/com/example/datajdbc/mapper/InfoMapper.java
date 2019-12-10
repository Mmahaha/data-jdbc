package com.example.datajdbc.mapper;

import com.example.datajdbc.bean.Info;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface InfoMapper {
     /*
    Edited by 伟欢
    创建词条；
    修改词条；
     */




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
