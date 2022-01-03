package beanWood.springBoot.productSize.controller;

import beanWood.springBoot.productSize.dto.IProductSize;
import beanWood.springBoot.productSize.model.ProductSize;

import java.util.List;
import java.util.Optional;

public interface ProductSizeController {
	ProductSize saveProductSize(IProductSize iProductSize);

	ProductSize updateProductSize(IProductSize iProductSize);

	List<ProductSize> findAllProductSize();

	Optional<ProductSize> findByIdProductSize(Long id);

	void deleteByIdProductSize(Long id);

	List<ProductSize> findByProductId(Long productId);

	void deleteAllByProductId(Long productId);
}
