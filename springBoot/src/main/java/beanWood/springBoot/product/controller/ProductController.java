package beanWood.springBoot.product.controller;

import beanWood.springBoot.product.dto.IProduct;
import beanWood.springBoot.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductController {
	Product saveProduct(IProduct iProduct);

	Optional<Product> findByIdProduct(Long id);

	List<Product> findAllProduct();

	void deleteByIdProduct(Long id);
}
