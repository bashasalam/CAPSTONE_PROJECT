package com.salambasha.medicare.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.salambasha.medicare.services.CategoryService;
import com.salambasha.medicare.services.ProductService;

@Controller
@RequestMapping("/MEDICARE/admin")
public class AdminController {
	
	Category category = new Category();
	
	Product product = new Product();
	
	@Autowired
	CategoryRepository cateRepo;
	
	@Autowired
	CategoryService categoryService;
	
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
	public String loginCheck(@RequestParam("adminName") String adminName,@RequestParam("password") String password,HttpSession session, Model model) {
//
//		HttpSession session=request.getSession();
//		session.setAttribute("adminName", adminName);
		Admin admin = adminService.loginCheck(adminName,password);
		
		//System.out.print(admin.getadminName());
		if(admin != null) {
				session.setAttribute("adminName", admin.getUserName());
			
			return "redirect:/MEDICARE/admin/"; 
		}else {
			String obj = "Current adminName and Password Mismatching";
			model.addAttribute("currentadminNamepasswordmismatch", obj);
			return "pages/admin/login"; 
		}
	} 
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam("adminName") String adminName,@RequestParam("currentPassword") String password,@RequestParam("newPassword") String newPassword,@RequestParam("confirmPassword") String confirmPassword,Model model) {

		if(newPassword.equals(confirmPassword) ) {
			Admin admin = adminService.loginCheck(adminName,password);
			 
			
		if(admin != null) {
			int admin_id = admin.getAdminId();
			adminService.changePassword(newPassword,admin_id);
			return "pages/admin/successful";
			}else {
				
				String obj = "Current adminName and Password Mismatching";
				model.addAttribute("currentadminNamepasswordmismatch", obj);
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
	public String showAdminDashboards(Model model,HttpSession session) {
		int value = 0;
		int enableValue=1;
		
		if(session.getAttribute("adminName")!=null ) {
			
			//String adminName = (String) session.getAttribute("adminName");
			
			//Admin admin = adminController.findByadminName
			
		
	List<Category> categories = cateRepo.findAll();
	
		model.addAttribute("categoryList", categories);
		
		List<Product> products = proRepo.findAll();
		
		List<Long> categoryIdlist = new ArrayList<Long>();
		List<Category> categoryList1 = new ArrayList<Category>();
		
		for (Product product:products) {
			
			categoryList1.add(product.getTheCategory());
			
			//categoryIdlist.add(product.getTheCategory());
		}
		
		for (Category category:categoryList1) {
			
			categoryIdlist.add(category.getCategoryId());
		}
		
		
		
		List<Category> engagedCategories = categoryService.findEngagedCategories(categoryIdlist);
		
		
//		model.addAttribute("productList", products);
		
		List<Product> enabledproducts = productService.findEnabledProducts(enableValue);
		model.addAttribute("enabledProductList", enabledproducts );
		
		List<Product> disabledproducts = productService.findDisabledProducts(value);
		model.addAttribute("disabledProductList", disabledproducts );
		System.out.println(session.getAttribute("adminName"));
		
		model.addAttribute("engagedCategories", engagedCategories);
		//categoryIdlist
		
		return "pages/admin/dashboard";
		}else {
			
			return "pages/admin/login";
		}
	}
	
	@GetMapping("/logout") 
	public String logout(HttpSession session) {
		
		session.setAttribute("adminName", null);
		
		return "pages/admin/login";
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
