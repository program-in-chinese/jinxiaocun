package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class 进出单 {

  private Long id;

  // 进货真, 出货假
  private boolean 进;

  private double 数量;

  @NotNull(message = "请选择一个商品")
  private 商品 商品;

  // TODO: 添加时间戳, 默认为记录添加的时间

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  @ManyToOne
  @JoinColumn(name = "商品id")
  public 商品 get商品() {
    return 商品;
  }

  public void set商品(商品 商品) {
    this.商品 = 商品;
  }
}
