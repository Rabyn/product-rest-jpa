package com.cubic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.ProductEntity;
import com.cubic.rest.Product;

@Component
public class ProductMapper {

	// Create
	public ProductEntity mapToProductEntity(final ProductEntity entity, final Product prod) {

		entity.setProductName(prod.getProductName());
		entity.setCat(prod.getCat());
		entity.setUpc(prod.getUPC());
		entity.setManufacturer(prod.getManufacturer());
		entity.setPrice(prod.getPrice());
		entity.setQuantity(prod.getQuantity());
		entity.setStat(prod.getStat());

		return entity;
	}

	// Find Data
	public Product mapToProduct(final ProductEntity entity) {
		Product result = new Product();
		result.setId(entity.getPk());
		result.setProductName(entity.getProductName());
		result.setCat(entity.getCat());
		result.setUPC(entity.getUpc());
		result.setManufacturer(entity.getManufacturer());
		result.setPrice(entity.getPrice());
		result.setQuantity(entity.getQuantity());
		result.setStat(entity.getStat());
		result.setCreatedDate(entity.getCreatedDate());
		result.setUpdatedDate(entity.getUpdatedDate());
		result.setActiveDate(entity.getActiveDate());
		result.setInactiveDate(entity.getInactiveDate());

		return result;
	}

	// Search Data
	public List<Product> mapToProductSearch(final List<ProductEntity> entities) {

		List<Product> result = new ArrayList<Product>();

		if (entities != null && !entities.isEmpty()) {
			for (ProductEntity entity : entities) {
				result.add(mapToProduct(entity));
			}
		}
		return result;
	}
}
