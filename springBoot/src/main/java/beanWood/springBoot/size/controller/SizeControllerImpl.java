package beanWood.springBoot.size.controller;

import beanWood.springBoot.size.model.Size;
import beanWood.springBoot.size.repository.SizeRepository;
import beanWood.springBoot.size.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/size")
public class SizeControllerImpl implements SizeController{
    @Autowired
    private SizeService sizeService;

    @Override
    @PostMapping("/save")
    public Size saveSize(Size size) {
        return sizeService.saveSize(size);
    }

    @Override
    @PostMapping("/find/{id}")
    public Optional<Size> findByIdSize(Long id) {
        return sizeService.findByIdSize(id);
    }

    @Override
    @PostMapping("/findAll")
    public List<Size> findAllSize() {
        return sizeService.findAllSize();
    }

    @Override
    @PostMapping("/delete/{id}")
    public void deleteByIdSize(Long id) {
        sizeService.deleteByIdSize(id);
    }
}
