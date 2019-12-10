package com.example.datajdbc.controller;

import com.example.datajdbc.bean.Info;
import com.example.datajdbc.mapper.InfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class InfoController {
    @Autowired
    InfoMapper infoMapper;
    //TODO 前缀统一用 "/info"


    /*
    Edited by 伟欢
    创建词条；
    修改词条信息；
     */




    /*
    Edited by 小棠
    展示词条列表(只要显示词条标题和词条id)；
    根据词条id获取具体信息；
     */
    @GetMapping("/info/select/all")
    public List<Map>getAllInfo(){return infoMapper.getAllInfo();}

    @GetMapping("/info/select/{infoid}")
    public Info getInfoById(@PathVariable("infoid") Integer infoid){return infoMapper.getInfoById(infoid);}



    /*
    Edited by 世杰
    删除词条；
    修改词条权限；
     */




}
