package com.AssignmentSpringBoot.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invoicedetail database table.
 * 
 */
@Entity
@NamedQuery(name="Invoicedetail.findAll", query="SELECT i FROM Invoicedetail i")
public class Invoicedetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idinvoicedetail;

	private int price;

	private int quantity;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name="idinvoice")
	private Invoice invoice;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idproduct")
	private Product product;

	public Invoicedetail() {
	}

	public int getIdinvoicedetail() {
		return this.idinvoicedetail;
	}

	public void setIdinvoicedetail(int idinvoicedetail) {
		this.idinvoicedetail = idinvoicedetail;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}