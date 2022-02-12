package com.mazedexpress.pm.controllers;

import java.util.List;

import javax.management.MBeanServerDelegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mazedexpress.pm.api.Product;
import com.mazedexpress.pm.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService prductService;
	
	@GetMapping("/showProductList")
	public String showProductList(Model model) {
		
		List<Product> productList=prductService.productList();
		model.addAttribute("products", productList);
		return "product-list";
	}
	
	
	@GetMapping("/showEntryPage")
	public String showEntryPage(Model model){
		Product product=new Product();
		model.addAttribute("product", product);
		//model.addAttribute("id",product.getId());
		return "add-product";
		
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(Product product) {
		if (product.getId()==0) {
			prductService.saveProduct(product);
		}else {
			prductService.updateProduct(product);
		}
		
		return "redirect:/showProductList";
	}
	
	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam("productId") int id,Model model) {
		Product product=prductService.getProductById(id);
		model.addAttribute("product", product);
		return "add-product";
		
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int id) {
		prductService.deleteProductById(id);
		return "redirect:/showProductList";
		
		
	}
	

}
