package beanWood.springBoot.productImage.controller;

import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.dto.OProductImage;
import beanWood.springBoot.productImage.model.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageController {
	ProductImage saveProductImage(IProductImage iproductImage);

	Optional<ProductImage> findByIdProductImage(Long id);

	List<ProductImage> findAllProductImage();

	ProductImage findImageProductId(Long productId);

	void deleteByIdProductImage(Long id);

	OProductImage findOProductImage(Long id);
}
