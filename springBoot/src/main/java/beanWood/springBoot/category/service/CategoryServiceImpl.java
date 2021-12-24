package beanWood.springBoot.category.service;

import beanWood.springBoot.category.model.Category;
import beanWood.springBoot.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Optional<Category> findByIdCategory(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteByIdCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
