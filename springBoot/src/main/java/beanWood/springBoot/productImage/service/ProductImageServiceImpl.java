package beanWood.springBoot.productImage.service;

import beanWood.springBoot.image.repository.ImageRepository;
import beanWood.springBoot.product.repository.ProductRepository;
import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.model.ProductImage;
import beanWood.springBoot.productImage.repository.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductImageServiceImpl implements ProductImageService {
	private final ProductImageRepository productImageRepository;
	private final ProductRepository productRepository;
	private final ImageRepository imageRepository;

	@Override
	public ProductImage saveProductImage(IProductImage iProductImage) {
		log.info("save productImage by : {}", iProductImage);
		return productImageRepository.save(
				ProductImage.builder()
						.id(iProductImage.getId())
						.image(imageRepository.findById(iProductImage.getImageId()).get())
						.product(productRepository.findById(iProductImage.getProductId()).get())
						.build()
		);
	}

	@Override
	public Optional<ProductImage> findByIdProductImage(Long id) {
		log.info("find by id productImage : {}", id);
		return productImageRepository.findById(id);
	}

	@Override
	public List<ProductImage> findAllProductImage() {
		log.info("find all productImage");
		return productImageRepository.findAll();
	}

	@Override
	public void deleteByIdProductImage(Long id) {
		log.info("delete by id productImage : {}", id);
		productImageRepository.deleteById(id);
	}

	@Override
	public List<ProductImage> findByProductId(Long productId) {
		log.info("find by productId productImage : {}", productId);
		return productImageRepository.findByProductId(productId);
	}

	@Override
	public void deleteAllByProductId(Long productId) {
		log.info("delete by productId productImage : {}", productId);
		productImageRepository.deleteAll(productImageRepository.findByProductId(productId));
	}
}
