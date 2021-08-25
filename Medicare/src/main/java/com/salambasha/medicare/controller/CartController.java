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
@RequestMapping("/cart")
public class CartController {
    
	@Autowired
	ProductService productService;
	
	
	@Autowired
	ProductCountController productCountController;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserController userController;

//	@PostMapping("/{cart_id}")
//	public String showUserCart(@PathVariable int cart_id) {
//		
//		return "pages/cart/cart-page";
//	}
	
	
	
	
	@PostMapping("/cartPage")
	public String showCartPage(HttpSession session,Model model, ProductCount proudctCount, @RequestParam("productId") long productId, @RequestParam(value="count", required=false) int count) {
		
		if(session.getAttribute("userId") != null) {
			
			long theUser = (long) session.getAttribute("userId");
			long theCart = (long) session.getAttribute("theCart");
			//System.out.println(" User id id" + userId);
			User user = userController.findById(theUser); 
			Cart cart = cartService.findByid(theCart);
		//	long productId = productCountController.
	ProductCount exitingProductCount =	productCountController.findProduct(productId);
			
			
			
		long theCart1 = cart.getCartId();
			
			System.out.println("cart is is "+ theCart1);
			if(exitingProductCount== null) {
				
					System.out.println("inside if");
					
				productCountController.saveProductCount(productId,count,cart,user);
					
			}else {
								
				System.out.println("inside else");
			long productCountId = productCountController.findPCid(productId);
			
			productCountController.updateProductCount(count,productCountId);
				
				//cartService.update(theCart);
				//productCountController.saveProductCount(productId,count,cart,user);
			}
			
				
		long cartId = cart.getCartId();
		System.out.println("cart id is" +cartId);
	
		
		 List<ProductCount> productCounts = productCountController.findProducts(theCart,theUser);
		 
		 List<Product> productList = new ArrayList<Product>();
		 List<Integer> productcountList = new ArrayList<Integer>();
		 List<Double> priceList = new ArrayList<Double>();
		 
		 for (ProductCount productCount : productCounts) {
			
			long cartProductId =  productCount.getProductId();
			
			int proCount = productCount.getCount();
			productcountList.add(proCount);
			
			Product cartProduct = productService.findById(cartProductId);
			
			productList.add(cartProduct);
			double offerPrice = cartProduct.getOfferPrice();
			
			priceList.add(offerPrice);
			
			
			 
		}
		 
		 double Total=0;
		 for (Double price : priceList) {
			 
			 Total = Total + price;
		 }
		 
		 System.out.println("The total is " + Total);
		 
		 
		 
		 System.out.print( "Product price list is"+priceList);

	System.out.print( "Product Count list is"+productcountList);
	model.addAttribute("priceList", priceList);
	 model.addAttribute("productCountList", productcountList);	
	 model.addAttribute("productList", productList);	
		
		//model.addAttribute("ProductCountList", productCounts);
session.setAttribute("userId", user.getUserId());
session.setAttribute("userName", user.getFullName());
session.setAttribute("theCart", cart.getCartId());
			
			return "pages/cart/order-summary";
			
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
//		return "pages/cart/order-summary";
//	}
	
	//@PostMapping("/checkout")
	@GetMapping("/payment")
	public String showPayment() {
		
		return "pages/cart/payment";
	}
	
	@GetMapping("/order-details")
	//@GetMapping("/order-details")
	public String showOrderDetails() {
		
		return "pages/cart/order-summary";
	}
	
	//@PostMapping("/checkout")
	@GetMapping("/success")
	public String showSuccess(HttpSession session) {
		
		long availableCartId = (long) session.getAttribute("theCart");
		
	//	Cart availableCart = cartService.findByid(availableCartId)
		int isActive = 0;
		cartService.changeIsActive(isActive,availableCartId);
		
		session.setAttribute("theCart", null);
		
		
		return "pages/cart/success";
	}
	
//	public String saveCart() {
//		
//		
//	}
	
	// here I need to change the cart as inActive and the session of theCart has to turned to null.
	
	
	
	
}
