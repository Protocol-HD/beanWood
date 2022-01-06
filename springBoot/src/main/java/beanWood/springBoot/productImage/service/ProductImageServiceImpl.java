package beanWood.springBoot.productImage.service;

import beanWood.springBoot.image.repository.ImageRepository;
import beanWood.springBoot.product.repository.ProductRepository;
import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.dto.OProductImage;
import beanWood.springBoot.productImage.model.ProductImage;
import beanWood.springBoot.productImage.repository.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
	public OProductImage findByIdProductImage(Long id) {
		log.info("find by id productImage : {}", id);
		OProductImage oProductImage = new OProductImage();
		try {
			ProductImage productImage = productImageRepository.findById(id).get();
			oProductImage = OProductImage.builder()
					.imageUrl(productImage.getImage().getImageUrl())
					.build();
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
		}
		return oProductImage;
	}

	@Override
	public List<OProductImage> findAllProductImage() {
		log.info("find all productImage");
		List<OProductImage> oProductImages = new ArrayList<>();
		try {
			productImageRepository.findAll().forEach(productImage -> {
				oProductImages.add(OProductImage.builder()
						.imageUrl(productImage.getImage().getImageUrl())
						.build());
			});
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
		}
		return oProductImages;
	}

	@Override
	public void deleteByIdProductImage(Long id) {
		log.info("delete by id productImage : {}", id);
		productImageRepository.deleteById(id);
	}

	@Override
	public List<OProductImage> findByProductId(Long productId) {
		log.info("find by productId productImage : {}", productId);
		List<OProductImage> oProductImages = new ArrayList<>();
		try {
			productImageRepository.findByProductId(productId).forEach(productImage -> {
				oProductImages.add(OProductImage.builder()
						.imageUrl(productImage.getImage().getImageUrl())
						.build());
			});
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
		}
		return oProductImages;
	}

	@Override
	public void deleteAllByProductId(Long productId) {
		log.info("delete by productId productImage : {}", productId);
		productImageRepository.deleteAll(productImageRepository.findByProductId(productId));
	}
}
