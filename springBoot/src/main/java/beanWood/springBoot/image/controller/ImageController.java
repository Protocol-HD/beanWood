package beanWood.springBoot.image.controller;

import beanWood.springBoot.image.model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageController {
    Image saveImage(Image image);

    Optional<Image> findByIdImage(Long id);

    List<Image> findAllImage();

    void deleteByIdImage(Long id);
}
