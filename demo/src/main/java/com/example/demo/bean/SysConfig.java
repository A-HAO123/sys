package com.example.demo.bean;


import java.sql.Date;
import java.sql.Time;

public class SysConfig {

  private String variable;
  private String value;
  private String setTime;
  private String setBy;
  private Assist assist;
//做新增测试时定义地构造方法
  public SysConfig(String variable, String value, String setTime, String setBy) {
    super();
    this.variable=variable;
    this.value=value;
    this.setTime=setTime;
    this.setBy=setBy;
  }
  public SysConfig() {
  }


  public String getVariable() {
    return variable;
  }

  public void setVariable(String variable) {
    this.variable = variable;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getSetTime() {
    return setTime;
  }

  public void setSetTime(String setTime) {
    this.setTime = setTime;
  }

  public String getSetBy() {
    return setBy;
  }

  public void setSetBy(String setBy) {
    this.setBy = setBy;
  }

  public Assist getAssist() {
    return assist;
  }

  public void setAssist(Assist assist) {
    this.assist = assist;
  }

}
