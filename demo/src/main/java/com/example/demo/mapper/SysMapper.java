package com.example.demo.mapper;

import com.example.demo.bean.SysConfig;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysMapper extends Mapper<SysConfig> {
    //多表查询
    public  List<SysConfig> findRelevance();


}
