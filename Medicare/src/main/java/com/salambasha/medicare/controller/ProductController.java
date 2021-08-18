package com.salambasha.medicare.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.salambasha.medicare.dao.CategoryRepository;
import com.salambasha.medicare.dao.ProductRepository;
import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.entities.Product;
import com.salambasha.medicare.services.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	@Autowired
    ProductService productService;
	
	@Autowired
	ProductRepository proRepo;
	@Autowired
	CategoryRepository cateRepo;


	@GetMapping("/{productId}")
	public String productDetailsShow(@PathVariable int productId) {
		
		return "/pages/products/product-page";
	}
	
	@GetMapping("")
	public String editProductPage(@RequestParam long editId, Model model) {
	Product product = productService.findByid(editId);
	System.out.print(product);
	model.addAttribute("editProduct", product);
	List<Category> categories = cateRepo.findAll();
	model.addAttribute("categoryList", categories);
	List<Product> products = proRepo.findAll();
		return "pages/admin/edit-madicine";
		}
	
	@GetMapping("/enable")
	public String productEnable(@RequestParam long enableId) {
		int enableValue = 1;
		int value = 0;
		productService.enableProduct(enableValue,enableId);	
		
		return "redirect:/admin";
	}
	@GetMapping("/disable")
	public String productDisable(@RequestParam long disableId,Model model) {
		int value = 0;
		productService.disableProduct(value,disableId);	 
		
		
		//System.out.print(disabledproducts);
		
		return "redirect:/admin";
	}
	
	
	@PostMapping("/save")	
	public String updateProduct(@RequestParam("productName") String productName, @RequestParam("brandName") String brandName,@RequestParam("description") String description, @RequestParam("price") double price,@RequestParam("theCategory") Category theCategory,@RequestParam("quantity") int quantity, @RequestParam("fileToUpload") MultipartFile[] files, String image) throws Exception {
		System.out.println("Working here-1");
		 StringBuilder fileName = new StringBuilder();
		 for(MultipartFile file : files) {
			 System.out.println("Working here1");
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileName.append(file.getOriginalFilename()+" ");
		  
		  try {
			Files.write(fileNameAndPath,file.getBytes());
			System.out.println("Working here1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Working here0");
		}
	}
		
	  image =  fileName.toString();
		System.out.println("Working here3");
		
		image =  "uploads/" + image;
		
		System.out.println("Working here4");
		  		
		   if(productService.addProduct(productName,brandName,description,price,theCategory,quantity,image)) {
			   System.out.println("Working here5");
			   return "redirect:/admin" ;
		   }else {
			   System.out.println("Working here6");
			   return "pages/products/addd-madicine";
		   }
	}


	
	
	@PostMapping("/update")
	public String saveProduct(@RequestParam("productName") String productName, @RequestParam("brandName") String brandName,@RequestParam("description") String description, @RequestParam("price") double price,@RequestParam("theCategory") Category theCategory,@RequestParam("quantity") int quantity, @RequestParam("fileToUpload") MultipartFile[] files, String image,@RequestParam("productId") long productId) throws Exception {
		System.out.println("Working here-5");
		 StringBuilder fileName = new StringBuilder();
		 for(MultipartFile file : files) {
			 System.out.println("Working here6");
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileName.append(file.getOriginalFilename()+" ");
		  
		  try {
			Files.write(fileNameAndPath,file.getBytes());
			System.out.println("Working here7");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Working here8");
		}
	}
		
	  image =  fileName.toString();
		System.out.println("Working here9");
		
		image =  "uploads/" + image;
		
		System.out.println("Working here10");
		  		
		   productService.updateProduct(productName,brandName,description,price,theCategory,quantity,image,productId);
			   System.out.println("Working here11");
			   return "redirect:/admin" ;
		 
	}
	
}
