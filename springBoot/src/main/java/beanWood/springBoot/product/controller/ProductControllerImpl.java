package beanWood.springBoot.product.controller;

import beanWood.springBoot.product.dto.IProduct;
import beanWood.springBoot.product.model.Product;
import beanWood.springBoot.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
	private final ProductService productService;

	@Override
	@PostMapping("/save")
	public Product saveProduct(@RequestBody IProduct iProduct) {
		return productService.saveProduct(iProduct);
	}

	@Override
	@PutMapping("/update")
	public Product updateProduct(@RequestBody IProduct iProduct) {
		return productService.saveProduct(iProduct);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<Product> findByIdProduct(@PathVariable Long id) {
		return productService.findByIdProduct(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<Product> findAllProduct() {
		return productService.findAllProduct();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdProduct(@PathVariable Long id) {
		productService.deleteByIdProduct(id);
	}

	@Override
	@GetMapping("/findByCategoryId/{categoryId}")
	public List<Product> findByCategoryId(@PathVariable Long categoryId) {
		return productService.findByCategoryId(categoryId);
	}
}
