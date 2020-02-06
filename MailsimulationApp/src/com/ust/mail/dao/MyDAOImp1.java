package com.ust.mail.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.mail.model.MailInfo;
import com.ust.mail.model.UserInfo;


@Component
public class MyDAOImp1 implements MyDAO{
	
	  @Autowired 
	  HttpSession session;
	 @Autowired
	 SessionFactory sf;

	@Override
	public UserInfo login(String email, String password) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", password));
		UserInfo sdto=(UserInfo) cr.uniqueResult();
		return sdto;
		
	}
	
	@Override
	public boolean register(UserInfo sdto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", sdto.getEmail()));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		if(dto!=null) {
		return false;
		}else {
			sdto.setSequestion("What is Your Nick Name");
			ss.save(sdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
	}

	@Override
	public List<MailInfo> inbox() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("toId",email1));
		cr.add(Restrictions.eq("status", "MailSent"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}
	
	@Override
	public List<MailInfo> message(HttpServletRequest request) {
		String id=request.getParameter("id");
		  int mid=Integer.parseInt(id);
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("id",mid));
		cr.add(Restrictions.eq("status", "MailSent"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}
	@Override
	public List<MailInfo> message1(HttpServletRequest request) {
		String id=request.getParameter("id");
		  int mid=Integer.parseInt(id);
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("id",mid));
		cr.add(Restrictions.eq("status", "MailSent"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public List<MailInfo> sent() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email1));
		cr.add(Restrictions.eq("status", "MailSent"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public List<MailInfo> draft() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email1));
		cr.add(Restrictions.eq("status", "DraftMail"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public UserInfo compose(String from, String to, String sub, String body) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", from));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", to));
		UserInfo udto=(UserInfo) cr.uniqueResult();
		List<MailInfo> list;
		if(udto!=null) {
		MailInfo mdto=new MailInfo();
		mdto.setFromId(from);
		mdto.setToId(to);
		mdto.setSubject(sub);
		mdto.setMessage(body);
		mdto.setStatus("MailSent");
		list=dto.getMlist();
		list.add(mdto);
		dto.setMlist(list);
		ss.save(dto);
		ss.beginTransaction().commit();
		Query qry=ss.createQuery("from MailInfo where id=?");
		qry.setParameter(0, new Integer(1));
		MailInfo dtoo=(MailInfo)qry.uniqueResult();
		
		ss.close();
		return dto;
		}else {
			MailInfo mdto=new MailInfo();
			mdto.setToId(to);
			mdto.setFromId(from);
			mdto.setSubject(sub);
			mdto.setMessage(body);
			mdto.setStatus("DraftMail");
			list=dto.getMlist();
			list.add(mdto);
			dto.setMlist(list);
			ss.save(dto);
			ss.beginTransaction().commit();
			ss.close();
			return null;
		}
	}
	@Override
	public UserInfo compose2(String from, String to, String sub, String body) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", from));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		 cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", to));
		UserInfo udto=(UserInfo) cr.uniqueResult();
		//cr=ss.createCriteria(UserInfo.class);
		//cr.add(Restrictions.eq("email", to));
		//UserInfo udto=(UserInfo) cr.uniqueResult();
		List<MailInfo> list;
		if(udto!=null) {
			int idd=(int)session.getAttribute("id");
			cr=ss.createCriteria(MailInfo.class);
			cr.add(Restrictions.eq("id", idd));

		MailInfo mdto=(MailInfo) cr.uniqueResult();
		mdto.setFromId(from);
		mdto.setToId(to);
		mdto.setSubject(sub);
		mdto.setMessage(body);
		mdto.setStatus("MailSent");
		list=udto.getMlist();
		list.add(mdto);
		dto.setMlist(list);
		ss.update(udto);
		ss.beginTransaction().commit();
		
		
		ss.close();
		return udto;
		}else {
			int idd=(int)session.getAttribute("id");
			cr=ss.createCriteria(MailInfo.class);
			cr.add(Restrictions.eq("id", idd));
			
	MailInfo mdto=(MailInfo) cr.uniqueResult();
		mdto.setFromId(from);
		mdto.setToId(to);
		mdto.setSubject(sub);
		mdto.setMessage(body);
		mdto.setStatus("DraftMail");
		list=dto.getMlist();
		list.add(mdto);
		dto.setMlist(list);
		ss.save(dto);
		ss.beginTransaction().commit();
		ss.close();

			return null;
		}
	}
	

	@Override
	public boolean forgot(String email, String password, String seqanswer, String cpassword) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("seqanswer", seqanswer));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		if(dto!=null) {
			if(password.equals(cpassword)) {
				dto.setPassword(cpassword);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}else {
			ss.close();
			return false;
			}
		}else {
		ss.close();
		return false;
   }
	}

	@Override
	public boolean change(String password, String cpassword) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		String email=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("email", email));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		if(dto!=null) {
			if(password.equals(cpassword)) {
				dto.setPassword(cpassword);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
				ss.close();
			return true;
			}else {
				ss.close();
				return false;
			}
		}else {
			ss.close();
			return false;
		}
		
	}

	@Override
	public boolean delete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			dto.setStatus("deletedMail");
			ss.saveOrUpdate(dto);
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
	public boolean finalDelete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			ss.save(dto);
			ss.delete(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
		return false;
		}
	}


	@Override
	public List<MailInfo> deletedMail() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email1));
		cr.add(Restrictions.eq("status", "deletedMail"));
		List<MailInfo> mlist=cr.list();
		Criteria cr1=ss.createCriteria(MailInfo.class);

		cr1.add(Restrictions.eq("toId",email1));
		cr1.add(Restrictions.eq("status", "deletedMail"));
		List<MailInfo> klist=cr1.list();
		//List<MailInfoDTO> newlist=add.list(klist);
		klist.addAll(mlist);
		return klist;
				
	}

	@Override
	public MailInfo message2(int id, MailInfo dto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id",id));
		MailInfo dto1=(MailInfo)cr.uniqueResult();
		return dto1;
	}

	
}

