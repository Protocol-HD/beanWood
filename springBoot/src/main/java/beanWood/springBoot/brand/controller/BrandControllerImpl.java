package beanWood.springBoot.brand.controller;

import beanWood.springBoot.brand.dto.IBrand;
import beanWood.springBoot.brand.model.Brand;
import beanWood.springBoot.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandControllerImpl implements BrandController {
	private final BrandService brandService;

	@Override
	@PostMapping("/save")
	public Brand saveBrand(@RequestBody IBrand iBrand) {
		return brandService.saveBrand(iBrand);
	}

	@Override
	@PutMapping("/update")
	public Brand updateBrand(@RequestBody IBrand iBrand) {
		return brandService.saveBrand(iBrand);
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
