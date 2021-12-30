package beanWood.springBoot.brand.service;

import beanWood.springBoot.brand.dto.IBrand;
import beanWood.springBoot.brand.model.Brand;
import beanWood.springBoot.brand.repository.BrandRepository;
import beanWood.springBoot.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
	private final BrandRepository brandRepository;
	private final ImageService imageService;

	@Override
	public Brand saveBrand(IBrand iBrand) {
		return brandRepository.save(
				Brand.builder()
						.id(iBrand.getId())
						.brandName(iBrand.getBrandName())
						.image(imageService.findByIdImage(iBrand.getImageId()).get())
						.build()
		);
	}

	@Override
	public List<Brand> findAllBrand() {
		return brandRepository.findAll();
	}

	@Override
	public Optional<Brand> findByIdBrand(Long id) {
		return brandRepository.findById(id);
	}

	@Override
	public void deleteByIdBrand(Long id) {
		brandRepository.deleteById(id);
	}
}
