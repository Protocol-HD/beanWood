package beanWood.springBoot.productSize.controller;

import beanWood.springBoot.productSize.dto.IProductSize;
import beanWood.springBoot.productSize.model.ProductSize;

import java.util.List;
import java.util.Optional;

public interface ProductSizeController {
	int saveProductSize(IProductSize iProductSize);

	int updateProductSize(IProductSize iProductSize);

	List<ProductSize> findAllProductSize();

	Optional<ProductSize> findByIdProductSize(Long id);

	int deleteByIdProductSize(Long id);

	List<ProductSize> findByProductId(Long productId);

	int deleteAllByProductId(Long productId);
}
