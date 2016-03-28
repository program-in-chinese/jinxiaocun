package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class 商品控制 {

	private 商品库 商品库;
	
	@Autowired
	public 商品控制(商品库 商品库) {
		this.商品库 = 商品库;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String 商品表(Model model) {
		List<商品> 商品表 = 商品库.findAll();
		if (商品表 != null) {
			model.addAttribute("商品表", 商品表);
		}
		return "商品表";
	}

	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String 添加商品(商品 商品) {
		商品库.save(商品);
		return "redirect:/products";
	}
}
