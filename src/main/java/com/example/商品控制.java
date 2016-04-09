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
@RequestMapping(value = "/商品表")
public class 商品控制 {

  protected static final String URL = "商品表";
  protected static final String 表名 = "商品表";

  @Autowired
  private 商品库 商品库;
  @Autowired
  private 单位库 单位库;

  @RequestMapping(method = RequestMethod.GET)
  public String 列表(Model 模型) {
    List<商品> 表 = 商品库.findAll();
    if (表 != null) {
      模型.addAttribute(表名, 表);
    }

    列出单位(模型);

    // 需要初始化被校验的对象
    模型.addAttribute("商品", new 商品());

    return URL;
  }

  @RequestMapping(method = RequestMethod.POST)
  public String 添加(@Valid 商品 商品, BindingResult 约束结果, Model 模型) {
    if (约束结果.hasErrors()) {
      列出单位(模型);

      return URL;
    }
    商品库.save(商品);
    return "redirect:/" + URL;
  }

  private void 列出单位(Model 模型) {
    List<单位> 所有单位 = 单位库.findAll();
    模型.addAttribute("所有单位", 所有单位);
  }

}
