package com.example;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class 进销存演示Application extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(进销存演示Application.class, args);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    try {
      registry.addRedirectViewController("/", "/" + URLEncoder.encode(商品控制.URL, "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
