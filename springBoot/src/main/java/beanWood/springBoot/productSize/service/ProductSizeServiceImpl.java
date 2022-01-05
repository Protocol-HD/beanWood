package beanWood.springBoot.productSize.service;

import beanWood.springBoot.product.repository.ProductRepository;
import beanWood.springBoot.productSize.dto.IProductSize;
import beanWood.springBoot.productSize.model.ProductSize;
import beanWood.springBoot.productSize.repository.ProductSizeRepository;
import beanWood.springBoot.size.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductSizeServiceImpl implements ProductSizeService {
	private final ProductSizeRepository productSizeRepository;
	private final ProductRepository productRepository;
	private final SizeRepository sizeRepository;

	@Override
	public ProductSize saveProductSize(IProductSize iProductSize) {
		log.info("save productSize by : {}", iProductSize);
		return productSizeRepository.save(
				ProductSize.builder()
						.id(iProductSize.getId())
						.product(productRepository.findById(iProductSize.getProductId()).get())
						.size(sizeRepository.findById(iProductSize.getSizeId()).get())
						.build()
		);
	}

	@Override
	public List<ProductSize> findAllProductSize() {
		log.info("find all productSize");
		return productSizeRepository.findAll();
	}

	@Override
	public Optional<ProductSize> findByIdProductSize(Long id) {
		log.info("find by id productSize : {}", id);
		return productSizeRepository.findById(id);
	}

	@Override
	public void deleteByIdProductSize(Long id) {
		log.info("delete by id productSize : {}", id);
		productSizeRepository.deleteById(id);
	}

	@Override
	public List<ProductSize> findByProductId(Long productId) {
		log.info("find by productId productSize : {}", productId);
		return productSizeRepository.findByProductId(productId);
	}

	@Override
	public void deleteAllByProductId(Long productId) {
		log.info("delete by productId productSize : {}", productId);
		productSizeRepository.deleteAll(productSizeRepository.findByProductId(productId));
	}
}
