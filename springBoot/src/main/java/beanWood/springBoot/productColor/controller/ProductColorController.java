package beanWood.springBoot.productColor.controller;

import beanWood.springBoot.productColor.dto.IProductColor;
import beanWood.springBoot.productColor.model.ProductColor;

import java.util.List;
import java.util.Optional;

public interface ProductColorController {
	int saveProductColor(IProductColor iProductColor);

	int updateProductColor(IProductColor iProductColor);

	List<ProductColor> findAllProductColor();

	Optional<ProductColor> findByIdProductColor(Long id);

	int deleteByIdProductColor(Long id);

	List<ProductColor> findByProductId(Long productId);

	int deleteAllByProductId(Long productId);
}
