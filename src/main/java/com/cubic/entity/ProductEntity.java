package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.cubic.rest.Category;
import com.cubic.rest.Status;

@Entity
@Table(name = "PRODUCT")
@NamedQueries({ @NamedQuery(name = QueryConstants.CHECK_UPC, query = "select c from ProductEntity c where c.upc = ?"),
		@NamedQuery(name = QueryConstants.PRODUCT_SEARCH, query = "select c from ProductEntity c where UPPER(c.productName) like UPPER(?)"),
		@NamedQuery(name = QueryConstants.PRODUCT_ALL, query = "select c from ProductEntity c") })
public class ProductEntity {

	@Id
	@Column(name = "PROD_ID")
	/*
	 * @SequenceGenerator(name = "custSeq", sequenceName = "CUST_SEQ",
	 * allocationSize = 1)
	 * 
	 * @GeneratedValue(generator = "custSeq")
	 */
	private String pk;

	@Column(name = "NAME")
	private String productName;

	@Enumerated(EnumType.STRING)
	@Column(name = "CATEGORY")
	private Category cat;

	@Column(name = "UPC")
	private String upc;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "QUANTITY")
	private int quantity;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status stat;

	@Column(name = "ACTIVE_DATE")
	private String activeDate;

	@Column(name = "INACTIVE_DATE")
	private String inactiveDate;

	@Column(name = "CREATED_DATE")
	private String createdDate;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStat() {
		return stat;
	}

	public void setStat(Status stat) {
		this.stat = stat;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(String inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
}
