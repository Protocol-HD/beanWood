package beanWood.springBoot.color.controller;

import beanWood.springBoot.color.model.Color;

import java.util.List;
import java.util.Optional;

public interface ColorController {
    Color saveColor(Color color);
    Optional<Color> findByIdColor(Long id);
    List<Color> findAllColor();
    void deleteByIdColor(Long id);
}
