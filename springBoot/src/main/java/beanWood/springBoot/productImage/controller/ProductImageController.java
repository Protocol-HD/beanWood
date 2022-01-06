package beanWood.springBoot.productImage.controller;

import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.model.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageController {
	int saveProductImage(IProductImage iproductImage);

	int updateProductImage(IProductImage iProductImage);

	Optional<ProductImage> findByIdProductImage(Long id);

	List<ProductImage> findAllProductImage();

	int deleteByIdProductImage(Long id);

	List<ProductImage> findByProductId(Long productId);

	int deleteAllByProductId(Long productId);
}
