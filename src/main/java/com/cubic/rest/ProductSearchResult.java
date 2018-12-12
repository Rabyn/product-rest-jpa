package com.cubic.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductSearchResult {

	private List<Product> products = null;

	public ProductSearchResult() {

	}

	public ProductSearchResult(final List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
