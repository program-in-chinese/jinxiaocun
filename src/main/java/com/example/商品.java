package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class 商品 {

  private Long id;

  @NotEmpty(message = "商品名称不可为空")
  @Size(max = 50, message = "商品长度不可超过50")
  private String 名称;

  @NotNull(message = "请选择一个单位")
  private 单位 单位;

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

  @ManyToOne
  @JoinColumn(name = "单位id")
  public 单位 get单位() {
      return 单位;
  }

  public void set单位(单位 单位) {
    this.单位 = 单位;
  }
}
