package beanWood.springBoot.productColor.controller;

import beanWood.springBoot.productColor.dto.IProductColor;
import beanWood.springBoot.productColor.model.ProductColor;
import beanWood.springBoot.productColor.service.ProductColorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productColor")
@CrossOrigin
@Slf4j
public class ProductColorControllerImpl implements ProductColorController {
	private final ProductColorService productColorService;

	@Override
	@PostMapping("/save")
	public int saveProductColor(@RequestBody IProductColor iProductColor) {
		try {
			productColorService.saveProductColor(iProductColor);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@PutMapping("/update")
	public int updateProductColor(@RequestBody IProductColor iProductColor) {
		try {
			productColorService.saveProductColor(iProductColor);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@GetMapping("/findAll")
	public List<ProductColor> findAllProductColor() {
		return productColorService.findAllProductColor();
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<ProductColor> findByIdProductColor(@PathVariable Long id) {
		return productColorService.findByIdProductColor(id);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public int deleteByIdProductColor(@PathVariable Long id) {
		try {
			productColorService.deleteByIdProductColor(id);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}

	}

	@Override
	@GetMapping("/findByProductId/{productId}")
	public List<ProductColor> findByProductId(@PathVariable Long productId) {
		return productColorService.findByProductId(productId);
	}

	@Override
	@DeleteMapping("/deleteByProductId/{productId}")
	public int deleteAllByProductId(@PathVariable Long productId) {
		try {
			productColorService.deleteAllByProductId(productId);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}
}
