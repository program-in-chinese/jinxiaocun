package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URLEncoder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = 进销存演示Application.class)
@WebAppConfiguration
public class 进销存演示ApplicationTests {

	@Autowired
	private WebApplicationContext 上下文;
	private MockMvc 模拟Mvc;

	@Before
	public void setupMockMvc() {
		模拟Mvc = MockMvcBuilders.webAppContextSetup(上下文).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void redirectFromRoot() throws Exception {
		模拟Mvc.perform(get("/")).andExpect(status().is3xxRedirection())
				.andExpect(header().string("Location", "/" + URLEncoder.encode(商品控制.URL, "UTF-8")));
	}

	@Test
	public void 商品表() throws Exception {
		模拟Mvc.perform(MockMvcRequestBuilders.get(new URI("/" + 商品控制.URL)))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name(商品控制.表名))
			.andExpect(MockMvcResultMatchers.model().attributeExists(商品控制.表名));
			// TODO: 测试需用H2而不是mysql
			//.andExpect(MockMvcResultMatchers.model().attribute(商品控制.表名, Matchers.is(Matchers.empty())));
	}
}
