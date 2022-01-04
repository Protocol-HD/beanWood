package beanWood.springBoot.product.service;

import beanWood.springBoot.category.service.CategoryService;
import beanWood.springBoot.product.dto.IProduct;
import beanWood.springBoot.product.model.Product;
import beanWood.springBoot.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	@Override
	public Product saveProduct(IProduct iProduct) {
		log.info("{}", iProduct);
		return productRepository.save(
				Product.builder()
						.id(iProduct.getId())
						.description(iProduct.getDescription())
						.sale(iProduct.getSale())
						.productName(iProduct.getProductName())
						.star(iProduct.getStar())
						.isNew(iProduct.isNew())
						.price(iProduct.getPrice())
						.category(categoryService.findByIdCategory(iProduct.getCategoryId()).get())
						.build()
		);
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

	@Override
	public List<Product> findByCategoryId(Long categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}
}
