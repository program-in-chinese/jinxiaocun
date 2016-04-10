package com.example;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/单位表")
public class 单位控制 {

  protected static final String URL = "单位表";
  protected static final String 表名 = "单位表";

  @Autowired
  private 单位库 单位库;

  @RequestMapping(method = RequestMethod.GET)
  public String 列表(Model 模型) {
    List<单位> 表 = 单位库.findAll();
    if (表 != null) {
      模型.addAttribute(表名, 表);
    }
    // 需要初始化被校验的对象
    模型.addAttribute("单位", new 单位());
    return URL;
  }

  @RequestMapping(method = RequestMethod.POST)
  public String 添加(@Valid 单位 单位, BindingResult 约束结果, Model 模型) throws UnsupportedEncodingException {
    if (约束结果.hasErrors()) {
      return URL;
    }
    单位库.save(单位);
    return 列表(模型);//"redirect:/" + URLEncoder.encode(URL, "UTF-8");
  }
}
