package com.salambasha.medicare.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.salambasha.medicare.dao.CategoryRepository;
import com.salambasha.medicare.dao.ProductRepository;
import com.salambasha.medicare.entities.Admin;
import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.entities.Product;
import com.salambasha.medicare.services.AdminService;
import com.salambasha.medicare.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	Category category = new Category();
	
	Product product = new Product();
	
	@Autowired
	CategoryRepository cateRepo;
	
	@Autowired
	ProductRepository proRepo;
	@Autowired
	ProductService productService;
	
	@Autowired
	AdminService adminService;
	
	@GetMapping
	public String showAdminLogin() {
		
		return "pages/admin/login";
	}
	@PostMapping("/loginCheck")
	public String loginCheck(@RequestParam("username") String username,@RequestParam("password") String password) {
//
//		HttpSession session=request.getSession();
//		session.setAttribute("userName", userName);
		Admin admin = adminService.loginCheck(username,password);
		
		//System.out.print(admin.getUserName());
		if(admin != null) {
				
			
			return "redirect:/admin/"; 
		}else {
			
			return "redirect:/admin"; 
		}
	} 
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam("username") String username,@RequestParam("currentPassword") String password,@RequestParam("newPassword") String newPassword,@RequestParam("confirmPassword") String confirmPassword,Model model) {

		if(newPassword.equals(confirmPassword) ) {
			Admin admin = adminService.loginCheck(username,password);
			
			
		if(admin != null) {
			int admin_id = admin.getAdminId();
			adminService.changePassword(newPassword,admin_id);
			return "pages/admin/successful";
			}else {
				
				String obj = "Current Username and Password Mismatching";
				model.addAttribute("currentusernamepasswordmismatch", obj);
				return("pages/admin/manage-password");
			}
			
			
		}else {
			
			String obj = "Passwords are not equal";
			
			model.addAttribute("passwordsNotEqual", obj);
			
			return("pages/admin/manage-password");
		}
	
		
		
	
	} 
 

//	@RequestMapping("/dashboard")
//	public String showAdminDashboard() {
//		
//		return "pages/admin/dashboard";
//	}

	@GetMapping("/")
	public String showAdminDashboards(Model model) {
		int value = 0;
		int enableValue=1;
	List<Category> categories = cateRepo.findAll();
	
		model.addAttribute("categoryList", categories);
		
//		List<Product> products = proRepo.findAll();
//		model.addAttribute("productList", products);
		
		List<Product> enabledproducts = productService.findEnabledProducts(enableValue);
		model.addAttribute("enabledProductList", enabledproducts );
		
		List<Product> disabledproducts = productService.findDisabledProducts(value);
		model.addAttribute("disabledProductList", disabledproducts );
		
		return "pages/admin/dashboard";
	}
	
	@GetMapping("/table") 
	public String showTables() {
		
		return "pages/admin/tables";
	}

	@GetMapping("/add-madicine")
	public String showAddMadicine(Model model) {
		
     List<Category> categories = cateRepo.findAll();
     model.addAttribute("categoryList", categories);
     
     model.addAttribute("productFormData", product);
		
		return "pages/admin/add-madicine";
	}
	
	@GetMapping("/add-category")
	public String showAddCategory(Model model) {
		
		model.addAttribute("categoryFormData", category);
		
		return "pages/admin/add-category";
	}

	@GetMapping("/add-products")
	public String showAddProducts() {
		
		return "pages/admin/add-products";
	}
	@GetMapping("/manage-password")
	public String showChangePassword() {
		
		return "pages/admin/manage-password";
	}

	
}
