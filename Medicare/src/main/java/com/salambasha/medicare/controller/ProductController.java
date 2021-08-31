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
import com.salambasha.medicare.entities.ProductCount;
import com.salambasha.medicare.services.ProductService;


@Controller
@RequestMapping("MEDICARE/products")
public class ProductController {
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	@Autowired
    ProductService productService;
	
	@Autowired
	ProductRepository proRepo;
	@Autowired
	CategoryRepository cateRepo;
	
	

	@GetMapping("/{productId}")
	public String productDetailsShow(@PathVariable long productId, Model model,ProductCount productCount) {
		//long product_id = productId;
		Product product = productService.findById(productId);
		System.out.print(product);
		Category category = product.getTheCategory();
		model.addAttribute("CategoryName",category.getCategoryName());
		model.addAttribute("showProduct", product);
		model.addAttribute("productCountFormData", productCount);
		return "/pages/products/product-page";
	}
	
	@GetMapping("")
	public String editProductPage(@RequestParam long editId, Model model) {
	Product product = productService.findById(editId);
	//System.out.print(product);
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
		
		return "redirect:/MEDICARE/admin/";
	}
	@GetMapping("/disable")
	public String productDisable(@RequestParam long disableId,Model model) {
		int value = 0;
		productService.disableProduct(value,disableId);	 
		
		
		//System.out.print(disabledproducts);
		
		return "redirect:/MEDICARE/admin/";
	}
	@GetMapping("/delete")
	public String productDelete(@RequestParam long deleteId,Model model) {
		//int value = 0;
		productService.deleteProduct(deleteId);	 
		
		
		//System.out.print(disabledproducts);
		
		return "redirect:/MEDICARE/admin/";
	}
	
	
	
	@PostMapping("/save")	
	public String saveProduct(@RequestParam("productName") String productName, @RequestParam("brandName") String brandName,@RequestParam("description") String description, @RequestParam("price") double price,@RequestParam("offer") double offer, @RequestParam("theCategory") Category theCategory,@RequestParam("quantity") int quantity, @RequestParam("fileToUpload") MultipartFile file, String image,
	@RequestParam("extraImage1") MultipartFile file1, String image1,@RequestParam("extraImage2") MultipartFile file2, String image2,@RequestParam("extraImage3") MultipartFile file3, String image3) throws Exception {
		
		double offerPricewor = price - (price * offer)/100 ;
		
		 double offerPrice = Math.round(offerPricewor * 100D) / 100D;

		System.out.println(offerPrice);
		 StringBuilder fileName = new StringBuilder();
		 StringBuilder fileName1 = new StringBuilder();
		 StringBuilder fileName2 = new StringBuilder();
		 StringBuilder fileName3 = new StringBuilder();
		// for(MultipartFile file : files) {
			
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  Path fileNameAndPath1 = Paths.get(uploadDirectory, file1.getOriginalFilename());
		  Path fileNameAndPath2 = Paths.get(uploadDirectory, file2.getOriginalFilename());
		  Path fileNameAndPath3 = Paths.get(uploadDirectory, file3.getOriginalFilename());
		  fileName.append(file.getOriginalFilename()+" ");
		  fileName1.append(file1.getOriginalFilename()+" ");
		  fileName2.append(file2.getOriginalFilename()+" ");
		  fileName3.append(file3.getOriginalFilename()+" ");
		  
		  try {
			Files.write(fileNameAndPath,file.getBytes());
			Files.write(fileNameAndPath1,file1.getBytes());
			Files.write(fileNameAndPath2,file2.getBytes());
			Files.write(fileNameAndPath3,file3.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
//}
		
	  image =  fileName.toString();
	  image1 =  fileName1.toString();
	  image2 =  fileName2.toString();
	  image3 =  fileName3.toString();
		
		
		  image =  "uploads/" + image;
		  image1 =  "uploads/" + image1;
		  image2 =  "uploads/" + image2;
		  image3=  "uploads/" + image3;
		
		System.out.println("Working here4");
		  		
		   if(productService.addProduct(productName,brandName,description,price,offer,offerPrice,theCategory,quantity,image,image1,image2,image3)) {
			   System.out.println("Working here5");
			   return "redirect:/MEDICARE/admin/" ;
		   }else {
			   System.out.println("Working here6");
			   return "pages/products/addd-madicine";
		   }
	}


	
	
	@PostMapping("/update")
	public String updateProduct(@RequestParam("productName") String productName, @RequestParam("brandName") String brandName,@RequestParam("description") String description, @RequestParam("price") double price,  @RequestParam("offer") double offer,@RequestParam("theCategory") Category theCategory,@RequestParam("quantity") int quantity, @RequestParam("fileToUpload") MultipartFile file, String image,
	@RequestParam("extraImage1") MultipartFile file1, String image1,@RequestParam("extraImage2") MultipartFile file2, String image2,@RequestParam("extraImage3") MultipartFile file3, String image3, @RequestParam("productId") long productId) throws Exception {
		
		double offerPrice = price - (price * offer)/100 ;

		 StringBuilder fileName = new StringBuilder();
		 StringBuilder fileName1 = new StringBuilder();
		 StringBuilder fileName2 = new StringBuilder();
		 StringBuilder fileName3 = new StringBuilder();
		// for(MultipartFile file : files) {
			
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  Path fileNameAndPath1 = Paths.get(uploadDirectory, file1.getOriginalFilename());
		  Path fileNameAndPath2 = Paths.get(uploadDirectory, file2.getOriginalFilename());
		  Path fileNameAndPath3 = Paths.get(uploadDirectory, file3.getOriginalFilename());
		  
		  fileName.append(file.getOriginalFilename()+" ");
		  fileName1.append(file1.getOriginalFilename()+" ");
		  fileName2.append(file2.getOriginalFilename()+" ");
		  fileName3.append(file3.getOriginalFilename()+" ");
		  
		  try {
			Files.write(fileNameAndPath,file.getBytes());
			Files.write(fileNameAndPath1,file1.getBytes());
			Files.write(fileNameAndPath2,file2.getBytes());
			Files.write(fileNameAndPath3,file3.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
//}
		
	  image =  fileName.toString();
	  image1 =  fileName1.toString();
	  image2 =  fileName2.toString();
	  image3 =  fileName3.toString();
		
		
		  image =  "uploads/" + image;
		  image1 =  "uploads/" + image1;
		  image2 =  "uploads/" + image2;
		  image3=  "uploads/" + image3;
		
		System.out.println("Working here4");
		productService.updateProduct(productName,brandName,description,price,offer,offerPrice,theCategory,quantity,image,image1,image2,image3,productId);
		return "redirect:/MEDICARE/admin/" ;
		 
	}

	

	
}
