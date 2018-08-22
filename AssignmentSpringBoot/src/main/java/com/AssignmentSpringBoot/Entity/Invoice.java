package com.AssignmentSpringBoot.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idinvoice;

	private String address;

	private String customername;

	private String money;

	private String numberphone;

	private String productname;

	private String quantity;

	public Invoice() {
	}

	public int getIdinvoice() {
		return this.idinvoice;
	}

	public void setIdinvoice(int idinvoice) {
		this.idinvoice = idinvoice;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getNumberphone() {
		return this.numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}