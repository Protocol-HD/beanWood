package beanWood.springBoot.category.service;

import beanWood.springBoot.category.dto.ICategory;
import beanWood.springBoot.category.model.Category;
import beanWood.springBoot.category.repository.CategoryRepository;
import beanWood.springBoot.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;
	private final ImageRepository imageRepository;

	@Override
	public Category saveCategory(ICategory iCategory) {
		log.info("save Category: {}", iCategory.getCategoryName());
		return categoryRepository.save(
				Category.builder()
						.id(iCategory.getId())
						.categoryName(iCategory.getCategoryName())
						.image(imageRepository.findById(iCategory.getImageId()).get())
						.build()
		);
	}

	@Override
	public Optional<Category> findByIdCategory(Long id) {
		log.info("find Category By Id: {}", id);
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findAllCategory() {
		log.info("find all Category");
		return categoryRepository.findAll();
	}

	@Override
	public void deleteByIdCategory(Long id) {
		log.info("delete Category By Id: {}", id);
		categoryRepository.deleteById(id);
	}
}
