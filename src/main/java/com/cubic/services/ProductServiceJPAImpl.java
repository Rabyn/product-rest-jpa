package com.cubic.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cubic.entity.ProductEntity;
import com.cubic.entity.QueryConstants;
import com.cubic.exception.InvalidDataException;
import com.cubic.exception.ProductAlreadyExistsException;
import com.cubic.exception.ProductNotFoundException;
import com.cubic.rest.Product;
import com.cubic.rest.Status;

@Service("jpaPS")
@Transactional
public class ProductServiceJPAImpl implements ProductService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProductMapper mapper;

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();

	// Create Product
	public String createProduct(Product prod) {

		validateProduct(prod);
		// Check for Duplication
		List<ProductEntity> check = checkProductAvailabilityByUpc(prod.getUPC());

		if (check != null && !check.isEmpty()) {
			throw new ProductAlreadyExistsException("Product Already Exists");
		}

		ProductEntity entity = mapper.mapToProductEntity(new ProductEntity(), prod);
		entity.setPk(UUID.randomUUID().toString());
		entity.setCreatedDate(dateFormat.format(date));
		if (prod.getStat() == Status.ACTIVE) {
			entity.setActiveDate(dateFormat.format(date));
		} else {
			entity.setInactiveDate(dateFormat.format(date));
		}
		em.persist(entity);
		return entity.getPk();
	}

	// Modify Product
	public void modifyProduct(Product prod) {

		// Check for Availability
		ProductEntity entity = em.find(ProductEntity.class, new String(prod.getId()));

		if (entity == null) {
			throw new ProductNotFoundException("Product not found with that UPC");
		}
		entity = mapper.mapToProductEntity(entity, prod);
		entity.setUpdatedDate(dateFormat.format(date));
		if (prod.getStat() == Status.ACTIVE) {
			if (entity.getActiveDate() == null) {
				entity.setActiveDate(dateFormat.format(date));
				entity.setInactiveDate(null);
			}
		} else {
			if (entity.getInactiveDate() == null) {
				entity.setInactiveDate(dateFormat.format(date));
				entity.setActiveDate(null);
			}
		}
		em.persist(entity);

	}

	// Remove Product
	public void removeProduct(String id) {

		ProductEntity entity = em.find(ProductEntity.class, new String(id));
		if (entity == null) {
			throw new ProductNotFoundException("Product not found with that id");
		}
		em.remove(entity);

	}

	// Find Product
	public Product findProduct(String upc) {

		ProductEntity entity = FindProductAvailabilityByUpc(upc);
		if (entity == null) {
			throw new ProductNotFoundException("Product not found with that UPC");
		}
		return mapper.mapToProduct(entity);
	}

	// Search Product
	public List<Product> searchProduct(String queryString) {

		queryString = StringUtils.isEmpty(queryString) ? "%" : queryString.trim() + "%";

		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstants.PRODUCT_SEARCH, ProductEntity.class);
		query.setParameter(1, queryString);
		List<ProductEntity> searchResults = query.getResultList();

		return mapper.mapToProductSearch(searchResults);
	}

	// Search ALl Products
	public List<Product> searchAllProduct() {

		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstants.PRODUCT_ALL, ProductEntity.class);
		List<ProductEntity> searchResults = query.getResultList();

		return mapper.mapToProductSearch(searchResults);
	}

	// Create Method
	private List<ProductEntity> checkProductAvailabilityByUpc(String upc) {
		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstants.CHECK_UPC, ProductEntity.class);
		query.setParameter(1, upc);
		return query.getResultList();
	}

	// Find Method
	private ProductEntity FindProductAvailabilityByUpc(String upc) {
		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstants.CHECK_UPC, ProductEntity.class);
		query.setParameter(1, upc);
		return query.getSingleResult();
	}

	private void validateProduct(Product prod) {
		if (prod == null || StringUtils.isEmpty(prod.getProductName()) || StringUtils.isEmpty(prod.getUPC())) {
			throw new InvalidDataException("Invalid Data provided to persist");
		}
	}

	/*
	 * private Long checkProductAvailabilityByUpc(String upc) { Long result
	 * =(Long)
	 * em.createNamedQuery(QueryConstants.CHECK_UPC).setParameter(1,upc).
	 * getSingleResult(); return result; }
	 */
}
