package com.example.demo.service;

import com.example.demo.bean.Assist;
import com.example.demo.bean.SysConfig;
import com.example.demo.mapper.AssistMapper;
import com.example.demo.mapper.SysMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysService {
    @Autowired
    SysMapper sysMapper;
    @Autowired
    AssistMapper assistMapper;
//分页查询（SysConfig表）
    public List<SysConfig> findAll() {

        List<SysConfig> sysConfigs = sysMapper.selectAll();

        return sysConfigs;
    }

    //多表查询（SysConfig表,Assist表）
    public List<SysConfig> findRelevance() {

        List<SysConfig> sysConfigs = sysMapper.findRelevance();

        return sysConfigs;
    }


//测试新增数据
    public void adddate() {
        for (int i = 0; i < 100; i++) {
            /* Assist表数据
            String assistName = UUID.randomUUID().toString().substring(0, 5) + i;
            assistMapper.insertSelective(new Assist(null,assistName));
            */
            /* SysConfig表数据*/
            String value  = UUID.randomUUID().toString().substring(0, 5) + i;
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String setTime =String.valueOf(df.format(new Date()));
            System.out.println(setTime);
            String  setBy=String.valueOf(i+7);
            sysMapper.insertSelective(new SysConfig(null,value,setTime,setBy));
        }
    }
}