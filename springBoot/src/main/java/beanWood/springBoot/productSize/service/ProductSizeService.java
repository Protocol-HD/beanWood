package beanWood.springBoot.productSize.service;

import beanWood.springBoot.productSize.dto.IProductSize;
import beanWood.springBoot.productSize.model.ProductSize;

import java.util.List;
import java.util.Optional;

public interface ProductSizeService {
	ProductSize saveProductSize(IProductSize iProductSize);

	List<ProductSize> findAllProductSize();

	Optional<ProductSize> findByIdProductSize(Long id);

	void deleteByIdProductSize(Long id);

	List<ProductSize> findByProductId(Long productId);

	void deleteAllByProductId(Long productId);
}
