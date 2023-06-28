package com.ssafy.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.SearchCondition;
import com.ssafy.product.model.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/")
	public String showIndex() {
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Product> list = productService.getProductList();
		model.addAttribute("list", list);
		return "/product/list";
	}
	
	@RequestMapping("registform")
	public String registform() {
		return "/product/registform";
	}
	
	@RequestMapping("regist")
	public String regist(Product product) {
		System.out.println("등록전 : "+product);
		productService.registProduct(product);
		System.out.println("등록후 : "+product);
//		return "redirect:list";  //키값을 몰라서 상세화면으로 사실 보낼수가 없었어... 
		return "redirect:detail?id="+product.getP_id();
	}
	
//	@RequestMapping( value = "detail", method = RequestMethod.GET)
//	@GetMapping("detail")
	@RequestMapping("detail")
	public String detail(Model model, int id) {
		Product product = productService.detailProduct(id);
		model.addAttribute("product", product);
		return "/product/detail";
	}
	
	@RequestMapping("delete")
	public String delete(int id) {
		productService.removeProduct(id);
		return "redirect:list";
	}
	
	@RequestMapping("updateform")
	public String updateform(Model model, int id) {
		model.addAttribute("product", productService.getProduct(id));
		return "/product/updateform";
	}
	
	@RequestMapping("update")
	public String update(Product product) {
		productService.modifyProduct(product);
		return "redirect:detail?id=" + product.getP_id();
	}
	
	//검색기능있다.
	
	@RequestMapping("search")
	public String search(Model model, SearchCondition condition) {
		List<Product> list = productService.search(condition);
		model.addAttribute("list", list);
		return "/product/list";
	}
	
	
	
}
