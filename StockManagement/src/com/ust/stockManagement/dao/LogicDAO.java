package com.ust.stockManagement.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.ust.stockManagement.Model.AdminRegistrationDTO;
import com.ust.stockManagement.Model.OrderDTO;
import com.ust.stockManagement.Model.ProductRegistrationDTO;
@Component
public interface LogicDAO {

public	boolean MangerRegistration(AdminRegistrationDTO rdto);
public boolean adminLogin(HttpServletRequest req) ;
public List<ProductRegistrationDTO> searchproduct(String search,String filter);
///public List<ProductRegistrationDTO> updateproduct(ModelDTO mdto) {
//public List<ModelDTO> searchproduct(String search,String filter) {
public boolean addproduct(ProductRegistrationDTO mdto);

public List<ProductRegistrationDTO> allproduct();


public List<ProductRegistrationDTO> updateproduct(ProductRegistrationDTO mdto);

public List<ProductRegistrationDTO> addtocart(ProductRegistrationDTO mdto);

public List<ProductRegistrationDTO> cartadded(ProductRegistrationDTO mdto);
public List<OrderDTO> showCart();

}
