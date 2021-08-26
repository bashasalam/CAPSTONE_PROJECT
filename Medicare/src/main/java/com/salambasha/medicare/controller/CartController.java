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

import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.Product;
import com.salambasha.medicare.entities.ProductCount;
import com.salambasha.medicare.entities.User;
import com.salambasha.medicare.services.CartService;
import com.salambasha.medicare.services.ProductService;

@Controller
@RequestMapping("MEDICARE/cart")
public class CartController {
    
	@Autowired
	ProductService productService;
	
	
	@Autowired
	ProductCountController productCountController;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserController userController;

	@GetMapping("/cart")
	public String showUserCart(HttpSession session,Model model) {
		
		long theUser=0;
		long theCart=0;
		if(session.getAttribute("userId")!=null) {
			theUser = (long) session.getAttribute("userId");
		}else {
			
			return "redirect:/MEDICARE/login/new";
		}
		
		//long theUser = (long) session.getAttribute("userId");
		
		
		if(session.getAttribute("theCart")!=null) {
			theCart = (long) session.getAttribute("theCart");
		}else {
			
			return "redirect:/MEDICARE/login/new";
		}
		

		Cart cart = cartService.findByid(theCart);
		System.out.println(cart.getCartId());
		System.out.println(cart);
		
		int isActive = cart.getIsActive();
		System.out.println(isActive);
		System.out.println(theUser);
		System.out.println(theCart);
		 
		if(isActive==1) {
		

		 List<ProductCount> productCounts = productCountController.findProducts(theCart,theUser);
		 
		if((productCounts==null)||(productCounts.isEmpty())) {
			model.addAttribute("cartEmpty", "Your Cart is Empty");
			System.out.println("Empty model attribute added");
			
			return "pages/cart/cart-page";
			
		}else {
		 List<Product> productList = new ArrayList<Product>();
			
			 List<Double> priceList = new ArrayList<Double>();
			 
			 for (ProductCount productCount : productCounts) {
				
				long cartProductId =  productCount.getProductId();
				
			
				
				Product cartProduct = productService.findById(cartProductId);
				
				productList.add(cartProduct);
	
				
				double productSumPrice = productCount.getMultipliedPrice();
				priceList.add(productSumPrice);
				
				 
			}
			 
			 double Total=0;
			 for (Double price : priceList) {
				 
				 Total = Total + price;
			 }
			 
			 model.addAttribute("productCountList", productCounts);	
			 model.addAttribute("productList", productList);	
			 model.addAttribute("sumTotal", Total);
			 
			 System.out.println("model attribute added");
		
		return "pages/cart/cart-page";
		}
		
	}else {
		
		
		model.addAttribute("cartEmpty", "Your Cart is Empty");
		System.out.println("Empty model attribute added");
		
		return "pages/cart/cart-page";
		
	}
		
		
	}
	
	
	
	
	@PostMapping("/cartPage")
	public String showCartPage(HttpSession session,Model model, ProductCount proudctCount, @RequestParam("productId") long productId, @RequestParam(value="count", required=false) int count) {
		
		if(session.getAttribute("userId") != null) {
			
			long theUser = (long) session.getAttribute("userId");
			long theCart = (long) session.getAttribute("theCart");
			
			User user = userController.findById(theUser); 
			Cart cart = cartService.findByid(theCart);
	
	ProductCount exitingProductCount =	productCountController.findProduct(productId,theCart,theUser);
			
			
			
		long theCart1 = cart.getCartId();
			
			System.out.println("cart is is "+ theCart1);
			if(exitingProductCount== null) {
				
					System.out.println("inside if");
					
					Product savingProduct = productService.findById(productId);
					
					double offerPrice = savingProduct.getOfferPrice();
					
					double totalPrice = offerPrice * count;
					
				productCountController.saveProductCount(productId,count,cart,user,offerPrice,totalPrice);
					
			}else {
								
				System.out.println("inside else");
				Product savingProduct = productService.findById(productId);
				
				double offerPrice = savingProduct.getOfferPrice();
				
				double totalPrice = offerPrice * count;
			long productCountId = productCountController.findPCid(productId);
			
			productCountController.updateProductCount(count,offerPrice,totalPrice,productCountId);
				
				
			}
			
				
		long cartId = cart.getCartId();
		System.out.println("cart id is" +cartId);
	
		
		 List<ProductCount> productCounts = productCountController.findProducts(theCart,theUser);
		 
		 List<Product> productList = new ArrayList<Product>();
	
		 List<Double> priceList = new ArrayList<Double>();
		 
		 for (ProductCount productCount : productCounts) {
			
			long cartProductId =  productCount.getProductId();
			
			
			
			Product cartProduct = productService.findById(cartProductId);
			
			productList.add(cartProduct);

			
			double productSumPrice = productCount.getMultipliedPrice();
			priceList.add(productSumPrice);
			
			 
		}
		 
		 double Total=0;
		 for (Double price : priceList) {
			 
			 Total = Total + price;
		 }
		 
		 System.out.println("The total is " + Total);
		 
		 
		 
		 System.out.print( "Product price list is"+priceList);

	System.out.print( "Product Count list is"+productCounts);
//	model.addAttribute("priceList", priceList);
	 model.addAttribute("productCountList", productCounts);	
	 model.addAttribute("productList", productList);	
	 model.addAttribute("sumTotal", Total);
		
		//model.addAttribute("ProductCountList", productCounts);
session.setAttribute("userId", user.getUserId());
session.setAttribute("userName", user.getFullName());
session.setAttribute("theCart", cart.getCartId());
//session.setAttribute("theProduct", );
			
			return "pages/cart/cart-page";
			
		}else {
			
			return"pages/login/login";
		}
		
		
		
	}

	
	@GetMapping("/address")
	public String showUserddressForm(HttpSession session) {
		
		
		
		return "pages/cart/cart-address";
	}
	
	
	
//	@PostMapping("/orderder")
//
//	public String showCheckout() {
//		
//		return "pages/cart/cart-page";
//	}
	
	//@PostMapping("/checkout")
	@GetMapping("/payment")
	public String showPayment() {
		
		return "pages/cart/payment";
	}
	
	@GetMapping("/order-details")
	//@GetMapping("/order-details")
	public String showOrderDetails() {
		
		return "pages/cart/cart-page";
	}
	
	//@PostMapping("/checkout")
	@GetMapping("/success")
	public String showSuccess(HttpSession session) {
		
		long availableCartId = (long) session.getAttribute("theCart");
		
	//	Cart availableCart = cartService.findByid(availableCartId)
		int isActive = 0;
		cartService.changeIsActive(isActive,availableCartId);
		
		//session.setAttribute("theCart", null);
		
		
		return "pages/cart/success";
	}
	
//	public String saveCart() {
//		
//		
//	}
	
	// here I need to change the cart as inActive and the session of theCart has to turned to null.
	
	
	
	
}
