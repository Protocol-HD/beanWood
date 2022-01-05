package beanWood.springBoot.brand.service;

import beanWood.springBoot.brand.dto.IBrand;
import beanWood.springBoot.brand.model.Brand;
import beanWood.springBoot.brand.repository.BrandRepository;
import beanWood.springBoot.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {
	private final BrandRepository brandRepository;
	private final ImageRepository imageRepository;

	@Override
	public Brand saveBrand(IBrand iBrand) {
		log.info("save Brand: {}", iBrand.getBrandName());
		return brandRepository.save(
				Brand.builder()
						.id(iBrand.getId())
						.brandName(iBrand.getBrandName())
						.image(imageRepository.findById(iBrand.getImageId()).get())
						.build()
		);
	}

	@Override
	public List<Brand> findAllBrand() {
		log.info("find all Brand: {}");
		return brandRepository.findAll();
	}

	@Override
	public Optional<Brand> findByIdBrand(Long id) {
		log.info("find Brand by Id: {}", id);
		return brandRepository.findById(id);
	}

	@Override
	public void deleteByIdBrand(Long id) {
		log.info("delete Brand by Id: {}", id);
		brandRepository.deleteById(id);
	}
}
