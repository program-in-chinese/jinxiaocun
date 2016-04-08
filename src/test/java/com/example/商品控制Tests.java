package com.example;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.net.URI;
import java.net.URLEncoder;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = 进销存演示Application.class)
@Transactional
@WebAppConfiguration
public class 商品控制Tests {

  private static final String 商品名 = "测试名";
  private static final long 商品ID = 1L;
  private static final String 单位名 = "单位名";
  private static final long 单位ID = 1L;

  @Autowired
  private WebApplicationContext 上下文;
  private MockMvc 模拟Mvc;

  @Before
  public void 设置模拟() {
    模拟Mvc = MockMvcBuilders.webAppContextSetup(上下文).build();
  }

  @Test
  public void 根路径转移() throws Exception {
    模拟Mvc.perform(get("/"))
        .andExpect(status().is3xxRedirection())
        .andExpect(header().string("Location", "/" + URLEncoder.encode(商品控制.URL, "UTF-8")));
  }

  @Test
  public void 商品表() throws Exception {
    模拟Mvc.perform(get(new URI("/" + 商品控制.URL)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(view().name(商品控制.表名))
        .andExpect(model().attributeExists(商品控制.表名))
        .andExpect(model().attribute(商品控制.表名, Matchers.is(Matchers.empty())));
  }

  @Test
  public void 添加() throws Exception {
    单位 期望单位 = new 单位();
    期望单位.setId(单位ID);
    期望单位.set名称(单位名);

    商品 期望商品 = new 商品();
    期望商品.setId(商品ID);
    期望商品.set名称(商品名);
    期望商品.set单位(期望单位);

    模拟Mvc.perform(post(new URI("/" + 单位控制.URL)).param("名称", 单位名))
        .andExpect(status().is3xxRedirection())
        .andExpect(header().string("Location", "/" + 单位控制.URL));

    模拟Mvc.perform(get(new URI("/" + 单位控制.URL)))
           .andExpect(status().isOk())
           .andExpect(view().name(单位控制.表名))
           .andExpect(model().attributeExists(单位控制.表名))
           .andExpect(model().attribute(单位控制.表名, hasSize(1)))
           .andExpect(model().attribute(单位控制.表名,
                        contains(samePropertyValuesAs(期望单位))));

    模拟Mvc.perform(post(new URI("/" + 商品控制.URL)).param("名称", 商品名).param("单位", Long.toString(单位ID)))
        .andExpect(status().is3xxRedirection())
        .andExpect(header().string("Location", "/" + 商品控制.URL));

    模拟Mvc.perform(get(new URI("/" + 商品控制.URL)))
           .andExpect(status().isOk())
           .andExpect(view().name(商品控制.表名))
           .andExpect(model().attributeExists(商品控制.表名))
           .andExpect(model().attribute(商品控制.表名, hasSize(1)))
           .andExpect(model().attribute(商品控制.表名, hasItem(
                        allOf(
                            hasProperty("id", equalTo(商品ID)),
                            hasProperty("名称", equalTo(商品名)),
                            hasProperty("单位", samePropertyValuesAs(期望单位))
                                    ))));
  }
}
