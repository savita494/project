package com.ust.stockManagement.Myservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.stockManagement.Model.AdminRegistrationDTO;
import com.ust.stockManagement.Model.OrderDTO;
import com.ust.stockManagement.Model.ProductRegistrationDTO;
import com.ust.stockManagement.dao.LogicDAO;
@Component
public class MyserviceImp implements Myservice {
	@Autowired 
	LogicDAO mdao;
	@Override
	public boolean MangerRegistration(AdminRegistrationDTO rdto) {
		// TODO Auto-generated method stub
		boolean b=mdao.MangerRegistration(rdto);
		return b;	}

	

	@Override
	public boolean adminLogin(HttpServletRequest req) {
		 boolean	b=mdao.adminLogin(req);
			
			return b;
	}



	@Override
	public List<ProductRegistrationDTO> searchproduct(String search, String filter) {

		
			List<ProductRegistrationDTO>mlist=mdao.searchproduct(search,filter);
			return  mlist;
		}

	@Override
	public boolean addproduct(ProductRegistrationDTO mdto) {
		// TODO Auto-generated method stub
		boolean b= mdao.addproduct(mdto);
		return b;
	}

	@Override
	public List<ProductRegistrationDTO> allproduct() {
		
		return mdao.allproduct();
	}
	
@Override
	public List<ProductRegistrationDTO> updateproduct(ProductRegistrationDTO mdto) {
		
		return mdao.updateproduct(mdto);
	}

	@Override
	public List<ProductRegistrationDTO> addtocart(ProductRegistrationDTO mdto) {
		// TODO Auto-generated method stub
		return mdao.addtocart(mdto);
	}

	@Override
	public List<ProductRegistrationDTO> cartadded(ProductRegistrationDTO mdto) {
		// TODO Auto-generated method stub
		return mdao.cartadded(mdto);
	}

	@Override
	public List<OrderDTO> showCart() {
		// TODO Auto-generated method stub
		return mdao.showCart();
	}
	

	}
	



