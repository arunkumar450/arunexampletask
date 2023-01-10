package com.practice.productbooking.model;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Production {
	@Id
	private String prodId;
	private String prodName;
	private String prodSize;
	private double prodCost;
	private int quantity;
	private String type;
	public Production() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Production(String prodId, String prodName, String prodSize, double prodCost, int quantity, String type) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodSize = prodSize;
		this.prodCost = prodCost;
		this.quantity = quantity;
		this.type = type;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdSize() {
		return prodSize;
	}
	public void setProdSize(String prodSize) {
		this.prodSize = prodSize;
	}
	public double getProdCost() {
		return prodCost;
	}
	public void setProdCost(double prodCost) {
		this.prodCost = prodCost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
