package beanWood.springBoot.brand.controller;

import beanWood.springBoot.brand.dto.IBrand;
import beanWood.springBoot.brand.model.Brand;
import beanWood.springBoot.brand.service.BrandService;
import beanWood.springBoot.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/brand")
public class BrandControllerImpl implements BrandController {

	@Autowired
	private BrandService brandService;
	@Autowired
	private ImageService imageService;

	@Override
	@PostMapping("/save")
	public Brand saveBrand(@RequestBody IBrand iBrand) {
		return brandService.saveBrand(
				Brand.builder()
						.image(imageService.findByIdImage(iBrand.getImageId()).get())
						.brandName(iBrand.getBrandName())
						.build()
		);
	}

	@Override
	@PutMapping("/update")
	public Brand updateBrand(@RequestBody IBrand iBrand) {
		return brandService.saveBrand(
				Brand.builder()
						.id(iBrand.getId())
						.image(imageService.findByIdImage(iBrand.getImageId()).get())
						.brandName(iBrand.getBrandName())
						.build()
		);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<Brand> findByIdBrand(@PathVariable Long id) {
		return brandService.findByIdBrand(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<Brand> findAllBrand() {
		return brandService.findAllBrand();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdProduct(@PathVariable Long id) {
		brandService.deleteByIdBrand(id);
	}
}
