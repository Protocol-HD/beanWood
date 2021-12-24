package beanWood.springBoot.brand.service;

import beanWood.springBoot.brand.model.Brand;
import beanWood.springBoot.brand.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> findAllBrand() {
		return brandRepository.findAll();
	}

	@Override
	public Optional<Brand> findByIdBrand(Long id) {
		return brandRepository.findById(id);
	}

	@Override
	public void deleteByIdBrand(Long id) {
		brandRepository.deleteById(id);
	}
}
