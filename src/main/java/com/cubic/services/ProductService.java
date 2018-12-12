package com.cubic.services;

import java.util.List;

import com.cubic.rest.Product;

public interface ProductService {

	String createProduct(final Product prod);

	void modifyProduct(final Product prod);

	void removeProduct(final String upc);

	Product findProduct(final String upc);

	List<Product> searchProduct(final String searchStr);

	List<Product> searchAllProduct();

}
