package beanWood.springBoot.productSize.service;

import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.productSize.dto.IProductSize;
import beanWood.springBoot.productSize.model.ProductSize;
import beanWood.springBoot.productSize.repository.ProductSizeRepository;
import beanWood.springBoot.size.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductSizeServiceImpl implements ProductSizeService {
	private final ProductSizeRepository productSizeRepository;
	private final ProductService productService;
	private final SizeService sizeService;

	@Override
	public ProductSize saveProductSize(IProductSize iProductSize) {
		return productSizeRepository.save(
				ProductSize.builder()
						.id(iProductSize.getId())
						.product(productService.findByIdProduct(iProductSize.getProductId()).get())
						.size(sizeService.findByIdSize(iProductSize.getSizeId()).get())
						.build()
		);
	}

	@Override
	public List<ProductSize> findAllProductSize() {
		return productSizeRepository.findAll();
	}

	@Override
	public Optional<ProductSize> findByIdProductSize(Long id) {
		return productSizeRepository.findById(id);
	}

	@Override
	public void deleteByIdProductSize(Long id) {
		productSizeRepository.deleteById(id);
	}

	@Override
	public List<ProductSize> findByProductId(Long productId) {
		return productSizeRepository.findByProductId(productId);
	}

	@Override
	public void deleteAllByProductId(Long productId) {
		findByProductId(productId).forEach(productSize -> {
			deleteByIdProductSize(productSize.getId());
		});
	}
}
