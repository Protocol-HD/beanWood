package beanWood.springBoot.brand.controller;

import beanWood.springBoot.brand.model.Brand;
import beanWood.springBoot.brand.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class BrandControllerImpl implements BrandController{

    @Autowired
    private BrandService brandService;

    @Override
    @PostMapping("/save")
    public Brand saveBrand(@RequestBody Brand brand) {
        return brandService.saveBrand(brand);
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
