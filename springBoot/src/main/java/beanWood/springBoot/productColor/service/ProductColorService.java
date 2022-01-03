package beanWood.springBoot.productColor.service;

import beanWood.springBoot.productColor.dto.IProductColor;
import beanWood.springBoot.productColor.model.ProductColor;

import java.util.List;
import java.util.Optional;

public interface ProductColorService {
	ProductColor saveProductColor(IProductColor iProductColor);

	List<ProductColor> findAllProductColor();

	Optional<ProductColor> findByIdProductColor(Long id);

	void deleteByIdProductColor(Long id);

	List<ProductColor> findByProductId(Long productId);

	void deleteAllByProductId(Long productId);
}
