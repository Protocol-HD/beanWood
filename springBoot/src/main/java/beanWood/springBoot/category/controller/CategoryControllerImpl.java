package beanWood.springBoot.category.controller;

import beanWood.springBoot.category.dto.ICategory;
import beanWood.springBoot.category.model.Category;
import beanWood.springBoot.category.service.CategoryService;
import beanWood.springBoot.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {
	private final CategoryService categoryService;

	@Autowired
	private ImageService imageService;

	@Override
	@PostMapping("/save")
	public Category saveCategory(@RequestBody ICategory iCategory) {
		return categoryService.saveCategory(iCategory);
	}

	@Override
	@PutMapping("/update")
	public Category updateCategory(@RequestBody ICategory iCategory) {
		return categoryService.saveCategory(iCategory);
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
