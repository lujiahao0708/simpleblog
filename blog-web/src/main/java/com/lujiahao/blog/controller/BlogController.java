package com.lujiahao.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 博客控制器
 * @author lujiahao
 * @date 2018/7/30
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
	
	@GetMapping
	public String listBlogs(@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="keyword",required=false) String keyword) {
		System.out.print("order:" +order + ";keyword:" + keyword );
		return "redirect:/index?order="+order+"&keyword="+ keyword;
	}

}
