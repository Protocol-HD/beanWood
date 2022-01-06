package beanWood.springBoot.productSize.controller;

import beanWood.springBoot.productSize.dto.IProductSize;
import beanWood.springBoot.productSize.dto.OProductSize;
import beanWood.springBoot.productSize.model.ProductSize;
import beanWood.springBoot.productSize.service.ProductSizeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productSize")
@CrossOrigin
@Slf4j
public class ProductSizeControllerImpl implements ProductSizeController {
	private final ProductSizeService productSizeService;

	@Override
	@PostMapping("/save")
	public int saveProductSize(@RequestBody IProductSize iProductSize) {
		try {
			productSizeService.saveProductSize(iProductSize);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@PutMapping("/update")
	public int updateProductSize(@RequestBody IProductSize iProductSize) {
		try {
			productSizeService.saveProductSize(iProductSize);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@GetMapping("/findAll")
	public List<OProductSize> findAllProductSize() {
		return productSizeService.findAllProductSize();
	}

	@Override
	@GetMapping("/find/{id}")
	public OProductSize findByIdProductSize(@PathVariable Long id) {
		return productSizeService.findByIdProductSize(id);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public int deleteByIdProductSize(@PathVariable Long id) {
		try {
			productSizeService.deleteByIdProductSize(id);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@GetMapping("/findByProductId/{productId}")
	public List<OProductSize> findByProductId(@PathVariable Long productId) {
		return productSizeService.findByProductId(productId);
	}

	@Override
	@DeleteMapping("/deleteByProductId/{productId}")
	public int deleteAllByProductId(@PathVariable Long productId) {
		try {
			productSizeService.deleteAllByProductId(productId);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}
}
