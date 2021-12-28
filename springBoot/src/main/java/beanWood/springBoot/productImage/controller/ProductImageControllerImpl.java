package beanWood.springBoot.productImage.controller;

import beanWood.springBoot.image.service.ImageService;
import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.dto.OProductImage;
import beanWood.springBoot.productImage.model.ProductImage;
import beanWood.springBoot.productImage.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/productImage")
public class ProductImageControllerImpl implements ProductImageController {
	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private ProductService productService;

	@Override
	public ProductImage findImageProductId(Long productId) {

		return null;
	}

	@Override
	@PostMapping("/save")
	public ProductImage saveProductImage(@RequestBody IProductImage iProductImage) {
		return productImageService.saveProductImage(
				ProductImage.builder()
						.image(imageService.findByIdImage(iProductImage.getImageId()).get())
						.product(productService.findByIdProduct(iProductImage.getProductId()).get())
						.build()
		);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<ProductImage> findByIdProductImage(@PathVariable Long id) {
		return productImageService.findByIdProductImage(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<ProductImage> findAllProductImage() {
		return productImageService.findAllProductImage();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdProductImage(@PathVariable Long id) {
		productImageService.deleteByIdProductImage(id);
	}

	@Override
	@GetMapping("/findProductImage/{id}")
	public OProductImage findOProductImage(@PathVariable Long id) {
		return OProductImage.builder()
				.productId(findByIdProductImage(id).get().getProduct().getId())
				.id(findByIdProductImage(id).get().getId())
				.image(findByIdProductImage(id).get().getImage())
				.build();
	}
}
