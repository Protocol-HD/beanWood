package beanWood.springBoot.product.repository;

import beanWood.springBoot.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
