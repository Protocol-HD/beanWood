package beanWood.springBoot.productImage.service;

import beanWood.springBoot.productImage.model.ProductImage;
import beanWood.springBoot.productImage.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	private ProductImageRepository productImageRepository;

	@Override
	public ProductImage saveProductImage(ProductImage productImage) {
		return productImageRepository.save(productImage);
	}

	@Override
	public Optional<ProductImage> findByIdProductImage(Long id) {
		return productImageRepository.findById(id);
	}

	@Override
	public List<ProductImage> findAllProductImage() {
		return productImageRepository.findAll();
	}

	@Override
	public void deleteByIdProductImage(Long id) {
		productImageRepository.deleteById(id);
	}

	@Override
	public List<ProductImage> findByProductId(Long productId) {
		return productImageRepository.findByProductId(productId);
	}
}
