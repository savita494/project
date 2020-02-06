package com.ust.mail.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.mail.dao.MyDAO;
import com.ust.mail.model.MailInfo;
import com.ust.mail.model.UserInfo;


@Component
public class MyServiceImp1 implements MyService{
	@Autowired
	MyDAO md;

	@Override
	public boolean register(UserInfo dto) {
		boolean b=md.register(dto);
		return b;
	}

	@Override
	public UserInfo login(String email, String password) {
		UserInfo dto=md.login(email, password);
		return dto;
	}

	@Override
	public List<MailInfo> inbox() {
		List<MailInfo> list=md.inbox();
		return list;
	}

	@Override
	public List<MailInfo> sent() {
		List<MailInfo> list=md.sent();
		return list;
	}

	@Override
	public List<MailInfo> draft() {
		List<MailInfo> list=md.draft();
		return list;
	}

	@Override
	public UserInfo compose(String from, String to, String sub, String body) {
		UserInfo dto=md.compose(from, to, sub, body);
		return dto;
	}
	@Override
	public UserInfo compose2(String from, String to, String sub, String body) {
		UserInfo dto=md.compose2(from, to, sub, body);
		return dto;
	}
	

	@Override
	public boolean forgot(String email, String password, String seqanswer, String cpassword) {
		boolean b=md.forgot(email, password, seqanswer, cpassword);
		return b;
	}

	@Override
	public boolean change(String password, String cpassword) {
		boolean b=md.change(password, cpassword);
		return b;
	}

	@Override
	public boolean delete(int id) {
		boolean b=md.delete(id);
		return b;
	}

	@Override
	public List<MailInfo> deletedMail() {
		List<MailInfo> list=md.deletedMail();
		return list;
	}

	@Override
	public List<MailInfo> message(HttpServletRequest request) {
		List<MailInfo> list=md.message(request);
		return list;
	}

	@Override
	public List<MailInfo> message1(HttpServletRequest request) {
		List<MailInfo> list=md.message(request);
		return list;
	}

	@Override
	public MailInfo message2(int id, MailInfo dto) {
		MailInfo adto=md.message2(id,dto);
		return adto;
	}

	@Override
	public boolean finalDelete(int id) {
		boolean b=md.finalDelete(id);
		return b;
	}




}
