package com.example;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class 商品控制 {

	private static final String 商品表URL = "商品表";

	private 商品库 商品库;
	
	@Autowired
	public 商品控制(商品库 商品库) {
		this.商品库 = 商品库;
	}
	
	@RequestMapping(value="/商品表", method=RequestMethod.GET)
	public String 列表(Model 模型) {
		List<商品> 商品表 = 商品库.findAll();
		if (商品表 != null) {
			模型.addAttribute("商品表", 商品表);
		}
		return 商品表URL;
	}

	@RequestMapping(value="/商品表", method=RequestMethod.POST)
	public String 添加(商品 商品) throws UnsupportedEncodingException {
		商品库.save(商品);
		return "redirect:/" + URLEncoder.encode(商品表URL, "UTF-8");
	}
}
