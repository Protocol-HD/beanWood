package beanWood.springBoot.productImage.repository;

import beanWood.springBoot.productImage.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
