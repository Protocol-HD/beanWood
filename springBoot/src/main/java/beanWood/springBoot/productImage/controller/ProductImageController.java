package beanWood.springBoot.productImage.controller;

import beanWood.springBoot.productImage.model.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageController {
    ProductImage saveProductImage(ProductImage productImage);

    Optional<ProductImage> findByIdProductImage(Long id);

    List<ProductImage> findAllProductImage();

    void deleteByIdProductImage(Long id);
}
