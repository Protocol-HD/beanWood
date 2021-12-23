package beanWood.springBoot.product.service;

import beanWood.springBoot.product.model.Product;
import beanWood.springBoot.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> findByIdProduct(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public void deleteByIdProduct(Long id) {
		productRepository.deleteById(id);
	}
}
