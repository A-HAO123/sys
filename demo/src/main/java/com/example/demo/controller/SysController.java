package com.example.demo.controller;

import com.example.demo.bean.Msg;
import com.example.demo.bean.SysConfig;
import com.example.demo.service.SysService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class SysController {
@Autowired
SysService sysService;
//页面跳转
    @RequestMapping(value="/test")
    public String testF2F() {
        return "index";

    }

    //查询用户表
    @RequestMapping("getAllSys")
    @ResponseBody
    public Object getAllSys(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn , 20);
        List<SysConfig> sysConfig =sysService.findAll();
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo<SysConfig> personPageInfo = new PageInfo<>(sysConfig,5);
        System.out.println("当前页码："+personPageInfo.getPageNum());
        System.out.println("总页码："+personPageInfo.getPages());
        System.out.println("总记录数："+personPageInfo.getTotal());
        System.out.println("在页面需要连续显示的页码");
        int[] nums = personPageInfo.getNavigatepageNums();
        for (int i : nums) {
            System.out.print(" "+i);
        }
        //得到分页中的person条目对象
        List<SysConfig> pageList = personPageInfo.getList();
        //将结果存入map进行传送
        Map<String, Object> result =new HashMap<>();
        result.put("pageInfo" , pageList);
        return result;
    }
    //查询用户表和辅助表
    @RequestMapping("findRelevance")
    @ResponseBody
    public Object findRelevance(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        //
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn , 10);
        List<SysConfig> sysConfig =sysService.findRelevance();
//        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        //方法一：
        PageInfo page = new PageInfo(sysConfig, 5);
        //使用工具类处理返回信息
        return Msg.success().add("pageInfo", page);
        //方法二：
//        PageInfo<SysConfig> personPageInfo = new PageInfo<>(sysConfig,5);
//        System.out.println("当前页码："+personPageInfo.getPageNum());
//        System.out.println("总页码："+personPageInfo.getPages());
//        System.out.println("总记录数："+personPageInfo.getTotal());
//        System.out.println("在页面需要连续显示的页码");
//        int[] nums = personPageInfo.getNavigatepageNums();
//        for (int i : nums) {
//            System.out.print(" "+i);
//        }
//        //得到分页中的person条目对象
//       List<SysConfig> pageList = personPageInfo.getList();
//        //将结果存入map进行传送
//        Map<String, Object> result =new HashMap<>();
//        result.put("pageInfo" , sysConfig);
//        return result;
    }







//测试新增数据
@RequestMapping("adddate")
@ResponseBody
    public String addsys(){

    sysService.adddate();

        return  "成功！！！" ;
};

}
