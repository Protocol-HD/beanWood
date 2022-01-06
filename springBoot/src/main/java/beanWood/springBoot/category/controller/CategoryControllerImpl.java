package beanWood.springBoot.category.controller;

import beanWood.springBoot.category.dto.ICategory;
import beanWood.springBoot.category.model.Category;
import beanWood.springBoot.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryControllerImpl implements CategoryController {
	private final CategoryService categoryService;

	@Override
	@PostMapping("/save")
	public int saveCategory(@RequestBody ICategory iCategory) {
		try {
			categoryService.saveCategory(iCategory);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@PutMapping("/update")
	public int updateCategory(@RequestBody ICategory iCategory) {
		try {
			categoryService.saveCategory(iCategory);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
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
