package beanWood.springBoot.brand.controller;

import beanWood.springBoot.brand.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandController {
	Brand saveBrand(Brand brand);

	Optional<Brand> findByIdBrand(Long id);

	List<Brand> findAllBrand();

	void deleteByIdProduct(Long id);
}
