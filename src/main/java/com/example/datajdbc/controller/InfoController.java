package com.example.datajdbc.controller;

import com.example.datajdbc.bean.Info;
import com.example.datajdbc.mapper.InfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class InfoController {
    //TODO 前缀统一用 "/info"


    /*
    Edited by 伟欢
    创建词条；
    修改词条信息；
     */

    @Autowired
    InfoMapper infoMapper;

    /*
    Edited by 伟欢
    创建词条；
    修改词条信息；
     */
    @PostMapping("/info/creatInfo")
    public Map<String,Object> creatInfo(@RequestBody Info info){
        infoMapper.creatInfo(info);
        Map res = new LinkedHashMap();
        res.put("status","success");
        res.put("infoId",info.getInfoId());
        res.put("userId",info.getUserId());
//        System.out.println(res);
        return res;
    }


    //修改词条信息
    @PostMapping("/info/updateInfo")
    public Object  updateInfo(@RequestBody Info info){
        Map<String,Object> res = new LinkedHashMap<>();
        infoMapper.updateInfo(info);
        res.put("status","success");
        return res;
    }

    @PostMapping("/info/all")
    public List<Info>selectAllInfos(){
        return infoMapper.selectAllInfos();
    }


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
