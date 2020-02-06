package com.ust.stockManagement.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ust.stockManagement.Model.AdminRegistrationDTO;
import com.ust.stockManagement.Model.OrderDTO;
import com.ust.stockManagement.Model.ProductRegistrationDTO;
import com.ust.stockManagement.Myservice.Myservice;


@Component
@RequestMapping("/")
public class MyController {
	@Autowired
	Myservice ms;
	
	
	HttpSession ss;
	@RequestMapping("/Register")
	public String reg() {
		return "Register";
	}
	@RequestMapping(value="/AdminRegistration",method=RequestMethod.POST)
	public ModelAndView AdminRegistration(@ModelAttribute AdminRegistrationDTO rdto) {
		boolean b=ms.MangerRegistration(rdto);
		if(b) {
			return new ModelAndView("Register","msg","Registration Sucessfull");
		}
		else
		{
			return new ModelAndView("Register","msg","User is already registered");
		}
	}
	@RequestMapping("/Login")
	public String log() {
		return "Login";
	}


	@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public ModelAndView adminLogin(HttpServletRequest req) {

		boolean  b=ms.adminLogin(req);
		if(b) {
			String email=req.getParameter("email");

			ss=req.getSession();
			ss.setAttribute("email", email);
			String user=(String) ss.getAttribute("email");
			System.out.println("Success");
			return  new ModelAndView("Home","user",user);
		}
		else {
			System.out.println("Failed");
			return new ModelAndView("Login","msg","Invalid Id or Password");
		}
	}
	@RequestMapping("/Home")
	public ModelAndView Home(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		if(email!=null){
		return new ModelAndView("Home","user",email);
	}else{
		return new ModelAndView("Login","msg","Login First");
	}}
		else{
			return new ModelAndView("Login","msg","Login First");

		}
	}
	@RequestMapping("/searchproduct")
	public String searchProduct(HttpServletRequest req){
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return "Searchpage";
	}else{
	 return "Login";	
	}
	}
	@RequestMapping("/searchData")
	public ModelAndView searchproduct(HttpServletRequest req){
		String search=req.getParameter("search");
		String filter=req.getParameter("searchBy");
		List<ProductRegistrationDTO>mlist=ms.searchproduct(search,filter);
		if(mlist.isEmpty()){
			return new ModelAndView("Searchpage","msg","This Product not avilable");	
	}else{
		return new ModelAndView("Searchpage","mlist",mlist);	
		
	}
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		ss.invalidate();
		return new ModelAndView("Login","msg","Logout Sucessfull");

		}
		else{
			return new ModelAndView("Login","msg","Logout Sucessfull");
		}
	}
	
	@RequestMapping("/addProduct")
		public ModelAndView add(){
		String email=(String) ss.getAttribute("email");
		if(email!=null){
			return new ModelAndView("regProduct");
	}else
	{
		return new ModelAndView("Login","msg","Login First");
	}
	}
	
	@RequestMapping(value="regProductt",method=RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute ProductRegistrationDTO mdto){
	System.out.println("inside Controller");
	String email=(String) ss.getAttribute("email");
	if(email!=null){
	boolean b=ms.addproduct(mdto);
	if(b){
	return new ModelAndView("regProduct","msg","Product added Successfully.");
	
	}else{
	return new ModelAndView("Home","msg","Product already in the cart.");
	}
	}
	else{			return new ModelAndView("Login","msg","Logout Sucessfull");
}
	}
	
	@RequestMapping("/showAllProduct")
	public ModelAndView showallproduct(){
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		List<ProductRegistrationDTO>mlist=ms.allproduct();
		if(mlist!=null){
		return new ModelAndView("Allproducts","mlist",mlist);
	}else{
		return new ModelAndView("Allproducts","msg","No product avilable");
	}
	}else{
		return new ModelAndView("Login","msg","Login First");
	}
}

	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute ProductRegistrationDTO mdto,HttpServletRequest req){
		ss=req.getSession(false);
		List<ProductRegistrationDTO>mlist=ms.updateproduct(mdto);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Allproducts","mlist",mlist);
	}else{
		return new ModelAndView("Login","msg","Login First");
	}
	}
	@RequestMapping("/addtocart")
	public ModelAndView addtocart(@ModelAttribute ProductRegistrationDTO mdto,HttpServletRequest req){
		ss=req.getSession();
		List<ProductRegistrationDTO>mlist=ms.addtocart(mdto);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Addcart","mlist",mlist);
		}else{
		return new ModelAndView("Login","msg","Login First");
		}
	}
	 
	@RequestMapping("/cartadded")
	public ModelAndView cartadded(@ModelAttribute ProductRegistrationDTO mdto){
		if(mdto==null)
		{ 			return new ModelAndView("Addcart","msg","plz select product");

			
	}
		else{
			ms.cartadded(mdto);
			return new ModelAndView("Home","mlist","Cart Added Success");
		}
			}
	
	@RequestMapping("/ShowCart")
	public ModelAndView ShowCart(@ModelAttribute ProductRegistrationDTO mdto,HttpServletRequest req){
		ss=req.getSession();
		List<OrderDTO>olist=ms.showCart();
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("ShowCart","olist",olist);
	}else{
		return new ModelAndView("Login","msg","Login First");

	}
}
}
