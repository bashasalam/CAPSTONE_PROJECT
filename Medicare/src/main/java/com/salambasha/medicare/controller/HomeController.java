package com.salambasha.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salambasha.medicare.dao.CategoryRepository;
import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.entities.Product;
import com.salambasha.medicare.services.ProductService;

@Controller
@RequestMapping("/MEDICARE")
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryRepository cateRepo;

    @GetMapping("/")
	public String showHome(Model model) {
    	long categoryId = 1;
    	List<Product> products = productService.getProducts(categoryId);
    	List<Category> categories = cateRepo.findAll(); 
			model.addAttribute("categoryList", categories);
			model.addAttribute("productList", products);
			System.out.print(products);
		return "pages/home";
	}
    
@RequestMapping("home/showMadicines")
public String showMadicines(@RequestParam("category_id") long categoryId,Model model) {
	
	//categoryId = (long)categoryId;
	//System.out.println(categoryId);
	
	//long category_id = 2;
	
	List<Product> products = productService.getProducts(categoryId);
	
	System.out.print(products);
	
	model.addAttribute("productList", products);
	
	//return 
	
	//exit(0);
	
	return "pages/selected";
	
	
}

@RequestMapping("home/showMadicineList")
public String showMadicineList(@RequestParam("enteredKey") String enteredKey,Model model) {
	
	//categoryId = (long)categoryId;
	//System.out.println(categoryId);
	
	//long category_id = 2;
	try {
	
	List<Product> products = productService.getKeyProducts(enteredKey);
	
	System.out.print(products);
	
	model.addAttribute("keyProductList", products);
	

	
	return "pages/keyProducts";
	}catch(Exception e ){
		
		model.addAttribute("productsNull"," There is No Products Available For Your Search");
		
		return "pages/keyProductNull";
	}
	
	
}



}


