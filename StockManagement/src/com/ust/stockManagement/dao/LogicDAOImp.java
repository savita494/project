package com.ust.stockManagement.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.stockManagement.Model.AdminRegistrationDTO;
import com.ust.stockManagement.Model.OrderDTO;
import com.ust.stockManagement.Model.ProductRegistrationDTO;
@Component
public class LogicDAOImp implements LogicDAO {
	@Autowired
	SessionFactory sf;
	@Override
	public boolean MangerRegistration(AdminRegistrationDTO rdto) {
		
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(AdminRegistrationDTO.class);
			cr.add(Restrictions.eq("email", rdto.getEmail()));
			AdminRegistrationDTO dto= (AdminRegistrationDTO) cr.uniqueResult();
			if(dto==null) {
				ss.save(rdto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}
			else
			{
				return false;
			}

		}

	@Override
	public boolean adminLogin(HttpServletRequest req) {
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		Session ss=sf.openSession();
		Criteria cr =ss.createCriteria(AdminRegistrationDTO.class);
		cr.add(Restrictions.eq("password",password));
		cr.add(Restrictions.eq("email",email));
		AdminRegistrationDTO rdto= (AdminRegistrationDTO) cr.uniqueResult();
		ss.beginTransaction().commit();
		ss.close();
		if(rdto!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<ProductRegistrationDTO> searchproduct(String search,String filter) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ProductRegistrationDTO.class);
		cr.add(Restrictions.ilike(filter,search, MatchMode.ANYWHERE));
		List<ProductRegistrationDTO>mlist=cr.list();
		return mlist;
	}
	@Override
	public boolean addproduct(ProductRegistrationDTO mdto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ProductRegistrationDTO.class);
		cr.add(Restrictions.eqOrIsNull("pname",mdto.getPname()));
		cr.add(Restrictions.eq("pcompany",mdto.getPcompany()));
		ProductRegistrationDTO dto=(ProductRegistrationDTO) cr.uniqueResult();
		if(dto==null){
		ss.save(mdto);
		ss.beginTransaction().commit();
		ss.close();
		return true;
	}else{
		ss.close();
		return false;
	}
	}


	@Override
	public List<ProductRegistrationDTO> allproduct() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ProductRegistrationDTO.class);
		List<ProductRegistrationDTO> mlist=cr.list();
		return mlist;
	}

	


	@Override
	public List<ProductRegistrationDTO> updateproduct(ProductRegistrationDTO mdto) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		ss.update(mdto);
		ss.beginTransaction().commit();
		Criteria cr=ss.createCriteria(ProductRegistrationDTO.class);
		List<ProductRegistrationDTO>mlist=cr.list();	
		return mlist;
	}

	@Override
	public List<ProductRegistrationDTO> addtocart(ProductRegistrationDTO mdto) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ProductRegistrationDTO.class);
		List<ProductRegistrationDTO>mlist=cr.list();
		for (ProductRegistrationDTO modelDTO : mlist) {
			System.out.println(modelDTO);
		}
		return mlist;

	}


	@Override
	public List<ProductRegistrationDTO> cartadded(ProductRegistrationDTO mdto) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		ProductRegistrationDTO mmdto=ss.load(ProductRegistrationDTO.class, mdto.getPid());
		mmdto.setPquantity(mmdto.getPquantity()-mdto.getPquantity());
		double tt=((mmdto.getPrice()*mdto.getPquantity())*1.5);
		OrderDTO odto=new OrderDTO(); 
		System.out.println(mdto.getPquantity());
		odto.setTprice(mdto.getPquantity()*mmdto.getPrice());
		odto.setTpricegst(tt);
		List<OrderDTO>olist=mmdto.getOlist();
		olist.add(odto);
		ss.saveOrUpdate(mmdto);
		ss.beginTransaction().commit();
		
		return null;
	}


	@Override
	public List<OrderDTO> showCart() {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(OrderDTO.class);
		List<OrderDTO>olist=cr.list();
		return olist;
	}
}
