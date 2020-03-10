package com.example.demo.bean;


public class Assist {

  private String assistId;
  private String assistName;

  public Assist(String assistId, String assistName) {
    this.assistId = assistId;
    this.assistName = assistName;
  }
  public Assist() {
  }

  public String getAssistId() {
    return assistId;
  }

  public void setAssistId(String assistId) {
    this.assistId = assistId;
  }


  public String getAssistName() {
    return assistName;
  }

  public void setAssistName(String assistName) {
    this.assistName = assistName;
  }

}
