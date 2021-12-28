package beanWood.springBoot.productImage.service;

import beanWood.springBoot.productImage.model.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageService {
	ProductImage saveProductImage(ProductImage productImage);

	Optional<ProductImage> findByIdProductImage(Long id);

	List<ProductImage> findAllProductImage();

	void deleteByIdProductImage(Long id);

	List<ProductImage> findByProductId(Long productId);
}
