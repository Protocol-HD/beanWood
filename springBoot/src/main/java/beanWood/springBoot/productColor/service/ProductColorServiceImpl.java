package beanWood.springBoot.productColor.service;

import beanWood.springBoot.color.service.ColorService;
import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.productColor.dto.IProductColor;
import beanWood.springBoot.productColor.model.ProductColor;
import beanWood.springBoot.productColor.repository.ProductColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductColorServiceImpl implements ProductColorService {
	private final ProductColorRepository productColorRepository;
	private final ProductService productService;
	private final ColorService colorService;

	@Override
	public ProductColor saveProductColor(IProductColor iProductColor) {
		return productColorRepository.save(
				ProductColor.builder()
						.id(iProductColor.getId())
						.color(colorService.findByIdColor(iProductColor.getColorId()).get())
						.product(productService.findByIdProduct(iProductColor.getProductId()).get())
						.build()
		);
	}

	@Override
	public List<ProductColor> findAllProductColor() {
		return productColorRepository.findAll();
	}

	@Override
	public Optional<ProductColor> findByIdProductColor(Long id) {
		return productColorRepository.findById(id);
	}

	@Override
	public void deleteByIdProductColor(Long id) {
		productColorRepository.deleteById(id);
	}

	@Override
	public List<ProductColor> findByProductId(Long productId) {
		return productColorRepository.findByProductId(productId);
	}

	@Override
	public void deleteAllByProductId(Long productId) {
		findByProductId(productId).forEach(productColor -> {
			deleteByIdProductColor(productColor.getId());
		});
	}
}
