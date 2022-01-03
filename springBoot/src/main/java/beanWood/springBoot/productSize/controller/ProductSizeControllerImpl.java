package beanWood.springBoot.productSize.controller;

import beanWood.springBoot.productSize.dto.IProductSize;
import beanWood.springBoot.productSize.model.ProductSize;
import beanWood.springBoot.productSize.service.ProductSizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productSize")
@CrossOrigin
public class ProductSizeControllerImpl implements ProductSizeController {
	private final ProductSizeService productSizeService;

	@Override
	@PostMapping("/save")
	public ProductSize saveProductSize(@RequestBody IProductSize iProductSize) {
		return productSizeService.saveProductSize(iProductSize);
	}

	@Override
	@PutMapping("/update")
	public ProductSize updateProductSize(@RequestBody IProductSize iProductSize) {
		return productSizeService.saveProductSize(iProductSize);
	}

	@Override
	@GetMapping("/findAll")
	public List<ProductSize> findAllProductSize() {
		return productSizeService.findAllProductSize();
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<ProductSize> findByIdProductSize(@PathVariable Long id) {
		return productSizeService.findByIdProductSize(id);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdProductSize(@PathVariable Long id) {
		productSizeService.deleteByIdProductSize(id);
	}

	@Override
	@GetMapping("/findByProductId/{productId}")
	public List<ProductSize> findByProductId(@PathVariable Long productId) {
		return productSizeService.findByProductId(productId);
	}

	@Override
	@DeleteMapping("/deleteByProductId/{productId}")
	public void deleteAllByProductId(@PathVariable Long productId) {
		productSizeService.deleteAllByProductId(productId);
	}
}
