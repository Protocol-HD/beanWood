package beanWood.springBoot.image.service;

import beanWood.springBoot.image.model.Image;
import beanWood.springBoot.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public Image saveImage(Image image) {
        log.info("save Image successfully: {}", image);
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> findByIdImage(Long id) {
        log.info("find by id Image: {}", id);
        return imageRepository.findById(id);
    }

    @Override
    public List<Image> findAllImage() {
        log.info("find all Image");
        return imageRepository.findAll();
    }

    @Override
    public void deleteByIdImage(Long id) {
        log.info("delete by id Image: {}", id);
        imageRepository.deleteById(id);
    }
}
