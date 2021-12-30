package beanWood.springBoot.category.service;

import beanWood.springBoot.category.dto.ICategory;
import beanWood.springBoot.category.model.Category;
import beanWood.springBoot.category.repository.CategoryRepository;
import beanWood.springBoot.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final ImageService imageService;

    @Override
    public Category saveCategory(ICategory iCategory) {
        return categoryRepository.save(
                Category.builder()
                        .id(iCategory.getId())
                        .categoryName(iCategory.getCategoryName())
                        .image(imageService.findByIdImage(iCategory.getImageId()).get())
                        .build()
        );
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
