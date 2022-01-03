package beanWood.springBoot.productColor.controller;

import beanWood.springBoot.productColor.dto.IProductColor;
import beanWood.springBoot.productColor.model.ProductColor;

import java.util.List;
import java.util.Optional;

public interface ProductColorController {
	ProductColor saveProductColor(IProductColor iProductColor);

	ProductColor updateProductColor(IProductColor iProductColor);

	List<ProductColor> findAllProductColor();

	Optional<ProductColor> findByIdProductColor(Long id);

	void deleteByIdProductColor(Long id);

	List<ProductColor> findByProductId(Long productId);

	void deleteAllByProductId(Long productId);
}
