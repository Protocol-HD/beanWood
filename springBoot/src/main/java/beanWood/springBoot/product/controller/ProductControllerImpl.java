package beanWood.springBoot.product.controller;

import beanWood.springBoot.category.service.CategoryService;
import beanWood.springBoot.color.service.ColorService;
import beanWood.springBoot.product.dto.IProduct;
import beanWood.springBoot.product.model.Product;
import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.productImage.service.ProductImageService;
import beanWood.springBoot.size.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ProductImageService productImageService;

	@Override
	@PostMapping("/save")
	public Product saveProduct(@RequestBody IProduct iProduct) {
		return productService.saveProduct(
				Product.builder()
						.category(categoryService.findByIdCategory(iProduct.getCategoryId()).get())
						.color(colorService.findByIdColor(iProduct.getColorId()).get())
						.size(sizeService.findByIdSize(iProduct.getSizeId()).get())
						.productName(iProduct.getProductName())
						.isNew(iProduct.isNew())
						.price(iProduct.getPrice())
						.sale(iProduct.getSale())
						.star(iProduct.getStar())
						.description(iProduct.getDescription())
						.build()
		);
	}

	@Override
	@PutMapping("/update")
	public Product updateProduct(@RequestBody IProduct iProduct) {
		return productService.saveProduct(
				Product.builder()
						.id(iProduct.getId())
						.category(categoryService.findByIdCategory(iProduct.getCategoryId()).get())
						.color(colorService.findByIdColor(iProduct.getColorId()).get())
						.size(sizeService.findByIdSize(iProduct.getSizeId()).get())
						.productName(iProduct.getProductName())
						.isNew(iProduct.isNew())
						.price(iProduct.getPrice())
						.sale(iProduct.getSale())
						.star(iProduct.getStar())
						.description(iProduct.getDescription())
						.build()
		);
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
