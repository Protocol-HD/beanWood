package beanWood.springBoot.product.controller;

import beanWood.springBoot.product.model.Product;
import beanWood.springBoot.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {
	@Autowired
	private ProductService productService;

	@Override
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
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
}
