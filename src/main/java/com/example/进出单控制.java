package com.example;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/进出单表")
public class 进出单控制 {

  protected static final String URL = "进出单表";
  protected static final String 表名 = "进出单表";

  @Autowired
  private 商品库 商品库;
  @Autowired
  private 进出单库 进出单库;

  @RequestMapping(method = RequestMethod.GET)
  public String 列表(Model 模型) {
    List<进出单> 表 = 进出单库.findAll();
    if (表 != null) {
      模型.addAttribute(表名, 表);
    }

    列出商品(模型);

    // 需要初始化被校验的对象
    模型.addAttribute("进出单", new 进出单());

    return URL;
  }

  @RequestMapping(method = RequestMethod.POST)
  public String 添加(@Valid 进出单 进出单, BindingResult 约束结果, Model 模型) {
    if (约束结果.hasErrors()) {
      列出商品(模型);

      return URL;
    }
    进出单库.save(进出单);
    return 列表(模型);
  }

  private void 列出商品(Model 模型) {
    List<商品> 所有商品 = 商品库.findAll();
    模型.addAttribute("所有商品", 所有商品);
  }
}
