package beanWood.springBoot.color.controller;

import beanWood.springBoot.color.model.Color;
import beanWood.springBoot.color.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/color")
public class ColorControllerImpl implements ColorController{

    @Autowired
    private ColorService colorService;

    @Override
    @PostMapping("/save")
    public Color saveColor(@RequestBody Color color) {
        return colorService.saveColor(color);
    }

    @Override
    @PostMapping("/find/{id}")
    public Optional<Color> findByIdColor(@PathVariable Long id) {
        return colorService.findByIdColor(id);
    }

    @Override
    @PostMapping("/findAll")
    public List<Color> findAllColor() {
        return colorService.findAllColor();
    }

    @Override
    @PostMapping("/delete/{id}")
    public void deleteByIdColor(Long id) {
        colorService.deleteByIdColor(id);
    }
}
