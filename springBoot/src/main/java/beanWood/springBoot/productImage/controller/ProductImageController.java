package beanWood.springBoot.productImage.controller;

import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.model.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageController {
    ProductImage saveProductImage(IProductImage iproductImage);

    Optional<ProductImage> findByIdProductImage(Long id);

    List<ProductImage> findAllProductImage();

    void deleteByIdProductImage(Long id);
}
