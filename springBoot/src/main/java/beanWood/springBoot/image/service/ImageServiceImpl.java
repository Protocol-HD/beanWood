package beanWood.springBoot.image.service;

import beanWood.springBoot.image.model.Image;
import beanWood.springBoot.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> findByIdImage(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public List<Image> findAllImage() {
        return imageRepository.findAll();
    }

    @Override
    public void deleteByIdImage(Long id) {
        imageRepository.deleteById(id);
    }
}
