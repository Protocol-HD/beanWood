package beanWood.springBoot.productImage.controller;

import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.model.ProductImage;
import beanWood.springBoot.productImage.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/productImage")
@RequiredArgsConstructor
public class ProductImageControllerImpl implements ProductImageController {
	private final ProductImageService productImageService;


	@Override
	@PostMapping("/save")
	public ProductImage saveProductImage(@RequestBody IProductImage iProductImage) {
		return productImageService.saveProductImage(iProductImage);
	}

	@Override
	@PutMapping("/update")
	public ProductImage updateProductImage(@RequestBody IProductImage iProductImage) {
		return productImageService.saveProductImage(iProductImage);
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
	@GetMapping("/findByProductId/{productId}")
	public List<ProductImage> findByProductId(@PathVariable Long productId) {
		return productImageService.findByProductId(productId);
	}

	@Override
	@DeleteMapping("/deleteByProductId/{productId}")
	public void deleteAllByProductId(@PathVariable Long productId) {
		productImageService.deleteAllByProductId(productId);
	}
}
