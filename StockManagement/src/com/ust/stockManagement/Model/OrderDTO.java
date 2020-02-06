package com.ust.stockManagement.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OrderDTO {

	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private int oid;
	private double tprice;
	private double tpricegst;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Order_History",joinColumns=@JoinColumn(name="oid"),inverseJoinColumns=@JoinColumn(name="pid"))
	private List<ProductRegistrationDTO>mlist;
	
	
	
	public List<ProductRegistrationDTO> getMlist() {
		return mlist;
	}
	public void setMlist(List<ProductRegistrationDTO> mlist) {
		this.mlist = mlist;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	public double getTpricegst() {
		return tpricegst;
	}
	public void setTpricegst(double tpricegst) {
		this.tpricegst = tpricegst; 
	}
}
