package com.example;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class 进出单 {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  // 进货真, 出货假
  private boolean 进;

  private double 数量;

  @ManyToOne
  @JoinColumn(name = "商品id")
  @NotNull(message = "请选择一个商品")
  private 商品 商品;

  // 默认为记录添加的时间
  @Column(name="创建时间", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
  private Date 创建时间;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean get进() {
    return 进;
  }

  public void set进(boolean 进) {
    this.进 = 进;
  }

  public double get数量() {
    return 数量;
  }

  public void set数量(double 数量) {
    this.数量 = 数量;
  }

  public 商品 get商品() {
    return 商品;
  }

  public void set商品(商品 商品) {
    this.商品 = 商品;
  }

  public Date get创建时间() {
    return 创建时间;
  }

  public void set创建时间(Date 创建时间) {
    this.创建时间 = 创建时间;
  }
}
