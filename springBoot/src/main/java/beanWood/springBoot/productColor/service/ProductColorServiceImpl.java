package beanWood.springBoot.productColor.service;

import beanWood.springBoot.color.repository.ColorRepository;
import beanWood.springBoot.product.repository.ProductRepository;
import beanWood.springBoot.productColor.dto.IProductColor;
import beanWood.springBoot.productColor.model.ProductColor;
import beanWood.springBoot.productColor.repository.ProductColorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductColorServiceImpl implements ProductColorService {
	private final ProductColorRepository productColorRepository;
	private final ProductRepository productRepository;
	private final ColorRepository colorRepository;

	@Override
	public ProductColor saveProductColor(IProductColor iProductColor) {
		log.info("save productColor by : {}", iProductColor);
		return productColorRepository.save(
				ProductColor.builder()
						.id(iProductColor.getId())
						.color(colorRepository.findById(iProductColor.getColorId()).get())
						.product(productRepository.findById(iProductColor.getProductId()).get())
						.build()

		);
	}

	@Override
	public List<ProductColor> findAllProductColor() {
		log.info("find all productColor");
		return productColorRepository.findAll();
	}

	@Override
	public Optional<ProductColor> findByIdProductColor(Long id) {
		log.info("find by id productColor : {}", id);
		return productColorRepository.findById(id);
	}

	@Override
	public void deleteByIdProductColor(Long id) {
		log.info("delete by id productColor : {}", id);
		productColorRepository.deleteById(id);
	}

	@Override
	public List<ProductColor> findByProductId(Long productId) {
		log.info("find by productId productColor : {}", productId);
		return productColorRepository.findByProductId(productId);
	}

	@Override
	public void deleteAllByProductId(Long productId) {
		log.info("delete by productId productColor : {}", productId);
		productColorRepository.deleteAll(productColorRepository.findByProductId(productId));
	}
}
