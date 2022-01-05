package beanWood.springBoot.product.service;

import beanWood.springBoot.category.repository.CategoryRepository;
import beanWood.springBoot.color.repository.ColorRepository;
import beanWood.springBoot.image.model.Image;
import beanWood.springBoot.image.repository.ImageRepository;
import beanWood.springBoot.product.dto.IProduct;
import beanWood.springBoot.product.model.Product;
import beanWood.springBoot.product.repository.ProductRepository;
import beanWood.springBoot.productColor.model.ProductColor;
import beanWood.springBoot.productColor.repository.ProductColorRepository;
import beanWood.springBoot.productImage.model.ProductImage;
import beanWood.springBoot.productImage.repository.ProductImageRepository;
import beanWood.springBoot.productSize.model.ProductSize;
import beanWood.springBoot.productSize.repository.ProductSizeRepository;
import beanWood.springBoot.size.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final ProductColorRepository productColorRepository;
	private final ProductImageRepository productImageRepository;
	private final ProductSizeRepository productSizeRepository;
	private final ImageRepository imageRepository;
	private final ColorRepository colorRepository;
	private final SizeRepository sizeRepository;

	public Product saveProductBefore(IProduct iProduct) {
		try {
			log.info("Save Product: {}", iProduct);
			return productRepository.save(Product.builder()
					.id(iProduct.getId())
					.description(iProduct.getDescription())
					.sale(iProduct.getSale())
					.productName(iProduct.getProductName())
					.star(iProduct.getStar())
					.isNew(iProduct.isNew())
					.price(iProduct.getPrice())
					.category(categoryRepository.findById(iProduct.getCategoryId()).get())
					.build());
		} catch (Exception exception) {
			log.error("Error: ", exception);
			return null;
		}
	}

	public List<Long> saveProductBefore2(IProduct iProduct) {
		try {
			List<Long> imageIds = new ArrayList<>();
			iProduct.getImages().forEach(
					image -> {
						imageIds.add(
								imageRepository.save(Image.builder()
										.imageUrl(image)
										.build()).getId());
					}
			);
			log.info("imageIds: {}", imageIds);
			return imageIds;
		} catch (Exception exception) {
			log.error("Error: ", exception);
			return null;
		}
	}

	@Override
	public Product saveProduct(IProduct iProduct) {
		try {
			log.info("Product save start");
			Product product = saveProductBefore(iProduct);
			log.info("Product save success, Image and ProductImage save start");
			saveProductBefore2(iProduct).forEach(
					imageId -> {
						productImageRepository.save(ProductImage.builder()
								.product(productRepository.findById(product.getId()).get())
								.image(imageRepository.findById(imageId).get())
								.build());
					}
			);
			log.info("Image and ProductImage save success, ProductColor save start");
			iProduct.getColorIds().forEach(
					colorId -> {
						productColorRepository.save(ProductColor.builder()
								.product(productRepository.findById(product.getId()).get())
								.color(colorRepository.findById(colorId).get())
								.build());
					}
			);
			log.info("ProductColor save success, ProductSize save start");
			iProduct.getSizeIds().forEach(
					sizeId -> {
						productSizeRepository.save(ProductSize.builder()
								.product(productRepository.findById(product.getId()).get())
								.size(sizeRepository.findById(sizeId).get())
								.build());
					}
			);
			log.info("ProductSize save success, All save success");
			return null;
		} catch (Exception exception) {
			log.error("Error: ");
			return null;
		}
	}

	@Override
	public Optional<Product> findByIdProduct(Long id) {
		log.info("find by id Product: {}", id);
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAllProduct() {
		log.info("find all Product");
		return productRepository.findAll();
	}


	public void deleteByIdProductBefore(Long id) {
		log.info("delete Product options by id Product: {}", id);
		try {
			log.info("delete ProductImage by id: {}", id);
			productImageRepository.deleteAll(productImageRepository.findByProductId(id));
			log.info("ProductImage delete success, delete ProductColor by id: {}", id);
			productColorRepository.deleteAll(productColorRepository.findByProductId(id));
			log.info("ProductColor delete success, delete ProductSize by id: {}", id);
			productSizeRepository.deleteAll(productSizeRepository.findByProductId(id));
			log.info(("ProductSize delete success"));
		} catch (Exception exception) {
			log.error("Error: ", exception);
		}
	}

	@Override
	public void deleteByIdProduct(Long id) {
		deleteByIdProductBefore(id);
		log.info("delete Product id: {}", id);
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findByCategoryId(Long categoryId) {
		log.info("find by category id Product: {}", categoryId);
		return productRepository.findByCategoryId(categoryId);
	}

	@Override
	public Product updateProduct(IProduct iProduct) {
		log.info("update Product: {}", iProduct);
		deleteByIdProductBefore(iProduct.getId());
		log.info("all delete success, save Product start");
		saveProduct(iProduct);
		return null;
	}
}
