package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class 商品 {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty(message = "商品名称不可为空")
  @Size(max = 50, message = "商品长度不可超过50")
  private String 名称;

  @Size(max = 10, message = "单位长度不可超过10")
  private String 单位;

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

  public String get单位() {
    return 单位;
  }

  public void set单位(String 单位) {
    this.单位 = 单位;
  }
}
