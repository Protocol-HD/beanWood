package beanWood.springBoot.productImage.service;

import beanWood.springBoot.image.service.ImageService;
import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.model.ProductImage;
import beanWood.springBoot.productImage.repository.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {
	private final ProductImageRepository productImageRepository;
	private final ProductService productService;
	private final ImageService imageService;

	@Override
	public ProductImage saveProductImage(IProductImage iProductImage) {
		return productImageRepository.save(
				ProductImage.builder()
						.id(iProductImage.getId())
						.image(imageService.findByIdImage(iProductImage.getImageId()).get())
						.product(productService.findByIdProduct(iProductImage.getProductId()).get())
						.build()
		);
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

	@Override
	public void deleteAllByProductId(Long productId) {
		findByProductId(productId).forEach(productImage -> {
			deleteByIdProductImage(productImage.getId());
		});
	}
}
