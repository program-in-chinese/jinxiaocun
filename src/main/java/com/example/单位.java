package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class 单位 {

  private long id;
  private String 名称;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String get名称() {
    return 名称;
  }

  public void set名称(String 名称) {
    this.名称 = 名称;
  }
}
