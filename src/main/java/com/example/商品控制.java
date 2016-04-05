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

  @RequestMapping(method = RequestMethod.GET)
  public String 列表(Model 模型) {
    List<商品> 商品表 = 商品库.findAll();
    if (商品表 != null) {
      模型.addAttribute(表名, 商品表);
    }
    // 需要初始化被校验的对象
    模型.addAttribute("商品", new 商品());
    return 表名;
  }

  @RequestMapping(method = RequestMethod.POST)
  public String 添加(@Valid 商品 商品, BindingResult 约束结果) {
    if (约束结果.hasErrors()) {
      return URL;
    }
    商品库.save(商品);
    return "redirect:/" + URL;
  }
}
