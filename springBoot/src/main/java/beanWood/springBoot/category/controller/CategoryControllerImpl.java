package beanWood.springBoot.category.controller;

import beanWood.springBoot.category.model.Category;
import beanWood.springBoot.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryControllerImpl implements CategoryController{

    @Autowired
    private CategoryService categoryService;

    @Override
    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @Override
    @GetMapping("/find/{id}")
    public Optional<Category> findByIdCategory(@PathVariable Long id) {
        return categoryService.findByIdCategory(id);
    }

    @Override
    @GetMapping("/findAll")
    public List<Category> findAllCategory() {
        return categoryService.findAllCategory();
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteByIdCategory(@PathVariable Long id) {
        categoryService.deleteByIdCategory(id);
    }
}
