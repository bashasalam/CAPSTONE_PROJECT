package com.salambasha.medicare.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.salambasha.medicare.dao.ProductRepository;
import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.services.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	@Autowired
    ProductService productService;
	
	@Autowired
	ProductRepository proRepo;


	@GetMapping("/{productId}")
	public String productDetailsShow(@PathVariable int productId) {
		
		return "/pages/products/product-page";
	}
	
	@PostMapping("/save")
	public String saveProduct(@RequestParam("productName") String productName, @RequestParam("brandName") String brandName,@RequestParam("description") String description, @RequestParam("price") double price,@RequestParam("theCategory") Category theCategory, @RequestParam("fileToUpload") MultipartFile[] files, String image) throws Exception {
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
		  		
		   if(productService.addProduct(productName,brandName,description,price,theCategory,image)) {
			   System.out.println("Working here5");
			   return "redirect:/admin" ;
		   }else {
			   System.out.println("Working here6");
			   return "pages/products/add-madicine";
		   }
	}
}
