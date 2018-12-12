package com.cubic.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private String id;
	private String productName;
	private Category cat;
	private String upc;
	private String manufacturer;
	private double price;
	private int quantity;
	private Status stat;
	private String activeDate;
	private String inactiveDate;
	private String createdDate;
	private String updatedDate;

	public String getId() {
		return id;
	}

	public Product setId(String id) {
		this.id = id;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public Product setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public Category getCat() {
		return cat;
	}

	public Product setCat(Category cat) {
		this.cat = cat;
		return this;
	}

	public String getUPC() {
		return upc;
	}

	public Product setUPC(String uPC) {
		this.upc = uPC;
		return this;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public Product setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		return this;
	}

	public double getPrice() {
		return price;
	}

	public Product setPrice(double price) {
		this.price = price;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public Status getStat() {
		return stat;
	}

	public Product setStat(Status stat) {
		this.stat = stat;
		return this;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public Product setActiveDate(String activeDate) {
		this.activeDate = activeDate;
		return this;
	}

	public String getInactiveDate() {
		return inactiveDate;
	}

	public Product setInactiveDate(String inactiveDate) {
		this.inactiveDate = inactiveDate;
		return this;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public Product setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public Product setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

}
