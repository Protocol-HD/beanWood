package beanWood.springBoot.productColor.controller;

import beanWood.springBoot.productColor.dto.IProductColor;
import beanWood.springBoot.productColor.model.ProductColor;
import beanWood.springBoot.productColor.service.ProductColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productColor")
@CrossOrigin
public class ProductColorControllerImpl implements ProductColorController {
	private final ProductColorService productColorService;

	@Override
	@PostMapping("/save")
	public ProductColor saveProductColor(@RequestBody IProductColor iProductColor) {
		return productColorService.saveProductColor(iProductColor);
	}

	@Override
	@PutMapping("/update")
	public ProductColor updateProductColor(@RequestBody IProductColor iProductColor) {
		return productColorService.saveProductColor(iProductColor);
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
	public void deleteByIdProductColor(@PathVariable Long id) {
		productColorService.deleteByIdProductColor(id);
	}

	@Override
	@GetMapping("/findByProductId/{productId}")
	public List<ProductColor> findByProductId(@PathVariable Long productId) {
		return productColorService.findByProductId(productId);
	}

	@Override
	@DeleteMapping("/deleteByProductId/{productId}")
	public void deleteAllByProductId(@PathVariable Long productId) {
		productColorService.deleteAllByProductId(productId);
	}
}
