package beanWood.springBoot.productImage.controller;

import beanWood.springBoot.productImage.model.ProductImage;
import beanWood.springBoot.productImage.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productImage")
public class ProductImageControllerImpl implements ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @Override
    @PostMapping("/save")
    public ProductImage saveProductImage(@RequestBody ProductImage productImage) {
        return productImageService.saveProductImage(productImage);
    }

    @Override
    @GetMapping("/find/{id}")
    public Optional<ProductImage> findByIdProductImage(@PathVariable Long id) {
        return productImageService.findByIdProductImage(id);
    }

    @Override
    @GetMapping("/findAll")
    public List<ProductImage> findAllProductImage() {
        return productImageService.findAllProductImage();
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteByIdProductImage(@PathVariable Long id) {
        productImageService.deleteByIdProductImage(id);
    }
}
