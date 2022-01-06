package beanWood.springBoot.productImage.controller;

import beanWood.springBoot.productImage.dto.IProductImage;
import beanWood.springBoot.productImage.dto.OProductImage;
import beanWood.springBoot.productImage.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/productImage")
@RequiredArgsConstructor
@Slf4j
public class ProductImageControllerImpl implements ProductImageController {
	private final ProductImageService productImageService;


	@Override
	@PostMapping("/save")
	public int saveProductImage(@RequestBody IProductImage iProductImage) {
		try {
			productImageService.saveProductImage(iProductImage);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@PutMapping("/update")
	public int updateProductImage(@RequestBody IProductImage iProductImage) {
		try {
			productImageService.saveProductImage(iProductImage);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@GetMapping("/find/{id}")
	public OProductImage findByIdProductImage(@PathVariable Long id) {
		return productImageService.findByIdProductImage(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<OProductImage> findAllProductImage() {
		return productImageService.findAllProductImage();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public int deleteByIdProductImage(@PathVariable Long id) {
		try {
			productImageService.deleteByIdProductImage(id);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@GetMapping("/findByProductId/{productId}")
	public List<OProductImage> findByProductId(@PathVariable Long productId) {
		return productImageService.findByProductId(productId);
	}

	@Override
	@DeleteMapping("/deleteByProductId/{productId}")
	public int deleteAllByProductId(@PathVariable Long productId) {
		try {
			productImageService.deleteAllByProductId(productId);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}
}
