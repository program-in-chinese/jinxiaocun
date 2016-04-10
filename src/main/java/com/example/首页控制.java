package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/首页")
public class 首页控制 {

  protected static final String URL = "首页";

  @RequestMapping(method = RequestMethod.GET)
  public String 列表() {
    return URL;
  }
}
