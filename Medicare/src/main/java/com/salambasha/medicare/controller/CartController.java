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

import com.salambasha.medicare.entities.Address;
import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.PaymentCard;
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
	
	
	@GetMapping("/pastcart")
	public String ShowPastCart(HttpSession session,Model model) {
		if(session.getAttribute("userId") != null) {
		long userId = (long) session.getAttribute("userId");
		
		//Object obj = "0000-00-00 00:00:00.000000";
		List<ProductCount> pastProductCountList = productCountController.findPastCartDetails(userId);
		
		model.addAttribute("purchasedProductList", pastProductCountList);
		
		return "pages/cart/cart-page";
		}else {
			
			return "pages/login/login";
		}
		
	}

	@GetMapping("/cart")
	public String showUserCart(HttpSession session,Model model, PaymentCard paymentCard) {
		
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
			model.addAttribute("paymentCardFormData", paymentCard);
			System.out.println("Empty model attribute added");
			
			return "pages/cart/order-summary";
			
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
			 
			 double Totalwor=0;
			 for (Double price : priceList) {
				 
				 Totalwor = Totalwor + price;
			 }
			 
			 double Total = Math.round(Totalwor * 100D) / 100D;
			 
			 model.addAttribute("productCountList", productCounts);	
			 model.addAttribute("productList", productList);	
			 model.addAttribute("sumTotal", Total);
			 model.addAttribute("paymentCardFormData", paymentCard);
			 
			 System.out.println("model attribute added");
		
		return "pages/cart/order-summary";
		}
		
	}else {
		
		 model.addAttribute("paymentCardFormData", paymentCard);
		model.addAttribute("cartEmpty", "Your Cart is Empty");
		System.out.println("Empty model attribute added");
		
		return "pages/cart/order-summary";
		
	}
		
		
	}
	
	
	
	
	@PostMapping("/cartPage")
	public String showCartPage(HttpSession session,Model model, 
			ProductCount proudctCount, @RequestParam("productId") long productId,
			@RequestParam(value="count", required=false) int count,PaymentCard paymentCard) {
		
		if(session.getAttribute("userId") != null) {
			
			long theUser = (long) session.getAttribute("userId");
			long theCart = (long) session.getAttribute("theCart");
			
			User user = userController.findById(theUser); 
			Cart cart = cartService.findByid(theCart);
			
	if(cart.getIsActive()!=0) {
	ProductCount exitingProductCount =	productCountController.findProduct(productId,theCart,theUser);
			
		long theCart1 = cart.getCartId();
			
			System.out.println("cart is is "+ theCart1);
			if(exitingProductCount== null) {
				
					System.out.println("inside if");
					
					Product savingProduct = productService.findById(productId);
					
					double offerPrice = savingProduct.getOfferPrice();
					
					 
					   
					
					String brandName = savingProduct.getBrandName();
					String madicineName = savingProduct.getProductName();
					String mainImage = savingProduct.getImage();
					
					double totalPricewor = offerPrice * count;
					 double totalPrice = Math.round(totalPricewor * 100D) / 100D;
					
				productCountController.saveProductCount(productId,count,cart,user,offerPrice,totalPrice,mainImage,madicineName,brandName);
					
			}else {
								
				System.out.println("inside else");
				long cartId = cart.getCartId();
				Product savingProduct = productService.findById(productId);
				
				double offerPrice = savingProduct.getOfferPrice();
				
				double totalPricewor = offerPrice * count;
				 double totalPrice = Math.round(totalPricewor * 100D) / 100D;
			long productCountId = productCountController.findPCid(productId,cartId);
			
			productCountController.updateProductCount(count,offerPrice,totalPrice,productCountId);
			
			return "redirect:/MEDICARE/cart/cart";	
				
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
		 
		 double Totalwor=0;
		 for (Double price : priceList) {
			 
			 Totalwor = Totalwor + price;
		 }
		 
		 double Total = Math.round(Totalwor * 100D) / 100D;
		 System.out.println("The total is " + Total);
		 
		 
		 
		 System.out.print( "Product price list is"+priceList);

	System.out.print( "Product Count list is"+productCounts);
//	model.addAttribute("priceList", priceList);
	 model.addAttribute("productCountList", productCounts);	
	 model.addAttribute("productList", productList);	
	 model.addAttribute("sumTotal", Total);
	 model.addAttribute("paymentCardFormData", paymentCard);
		
		//model.addAttribute("ProductCountList", productCounts);
session.setAttribute("userId", user.getUserId());
session.setAttribute("userName", user.getFullName());
session.setAttribute("theCart", cart.getCartId());
//session.setAttribute("theProduct", );

			
			return "pages/cart/order-summary";
			
		}else {
			
			//Create a new cart
			int isActive = 1;
			
			cartService.save(user,isActive);
  			Cart newCart = cartService.findSingleCart(user,isActive);
  			session.setAttribute("theCart", newCart.getCartId());
  			session.setAttribute("userName", user.getFullName());
            session.setAttribute("userId", user.getUserId());
			
			return "redirect:/MEDICARE/cart/cart/";
			
		}
			
		}else {
			
			return"pages/login/login";
		}
		
		
		
	}

	@RequestMapping("/changeCount")
	public String prductCountChange(@RequestParam("cartId") long cartId,
			@RequestParam("userId") long userId,
			@RequestParam("changedCount") int count, @RequestParam("countTableId") long countTableId,
			Model model,HttpSession session,PaymentCard paymentCard) {
		
		User user = userController.findById(userId);
		Cart cart = cartService.findByid(cartId);
				
		ProductCount productCount1 = productCountController.findByid(countTableId);
		
		long productId = productCount1.getProductId();
		
		Product savingProduct = productService.findById(productId);
		
		double offerPrice = savingProduct.getOfferPrice();
		
	//	double totalPricewor = offerPrice * count;
	//long productCountId = productCountController.findPCid(productId);
		
		double totalPricewor = offerPrice * count;
		 double totalPrice = Math.round(totalPricewor * 100D) / 100D;
	
	productCountController.updateProductCount(count,offerPrice,totalPrice,countTableId);
	
	List<ProductCount> productCounts = productCountController.findProducts(cartId,userId);
	 
	 List<Product> productList = new ArrayList<Product>();

	 List<Double> priceList = new ArrayList<Double>();
	 
	 for (ProductCount productCount : productCounts) {
		
		long cartProductId =  productCount.getProductId();
		
		
		
		Product cartProduct = productService.findById(cartProductId);
		
		productList.add(cartProduct);

		
		double productSumPrice = productCount.getMultipliedPrice();
		priceList.add(productSumPrice);
		
		 
	}
	 
	 double Totalwor=0;
	 for (Double price : priceList) {
		 
		 Totalwor = Totalwor + price;
	 }
	 
	 double Total = Math.round(Totalwor * 100D) / 100D;
	 System.out.println("The total is " + Total);
	 
	 
	 
	 System.out.print( "Product price list is"+priceList);

System.out.print( "Product Count list is"+productCounts);
//model.addAttribute("priceList", priceList);
model.addAttribute("productCountList", productCounts);	
model.addAttribute("productList", productList);	
model.addAttribute("sumTotal", Total);
model.addAttribute("paymentCardFormData", paymentCard);
	
	//model.addAttribute("ProductCountList", productCounts);
session.setAttribute("userId", user.getUserId());
session.setAttribute("userName", user.getFullName());
session.setAttribute("theCart", cart.getCartId());
//session.setAttribute("theProduct", );
		
		
		
		return"pages/cart/order-summary";
	}
	
	
	@RequestMapping("/removeProduct")
	public String removeProduct(@RequestParam("productId") long productId, @RequestParam("countTableId") long countTableId,HttpSession session, Model model) {
		
		productCountController.deleteById(countTableId);
		
		
		return"redirect:/MEDICARE/cart/cart";
	}
	
	
	
	@GetMapping("/address")
	public String showUserddressForm(HttpSession session, Address address,Model model) {
		
		
		model.addAttribute("addressFromData", address);
		model.addAttribute("paymentSuccessful", "Your Payment is Successfull");
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
//		
//		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		   LocalDateTime now = LocalDateTime.now();
//		   System.out.println(dtf.format(now));
		 
		   // 2021-03-24 16:48:05.591
		//   Timestamp timestamp = new Timestamp(System.currentTimeMillis());

//		   // 2021-03-24 16:48:05.591
//		   Date date = new Date();
//		   Timestamp timestamp2 = new Timestamp(date.getTime());
//
//		   // convert Instant to Timestamp
//		   Timestamp ts = Timestamp.from(Instant.now())

		
		
		return "pages/cart/success";
	}
	
//	public String saveCart() {
//		
//		
//	}
	
	// here I need to change the cart as inActive and the session of theCart has to turned to null.
	
	
	
	
}
