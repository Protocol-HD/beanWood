package beanWood.springBoot.size.service;

import beanWood.springBoot.size.model.Size;
import beanWood.springBoot.size.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService{

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public Size saveSize(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public Optional<Size> findByIdSize(Long id) {
        return sizeRepository.findById(id);
    }

    @Override
    public List<Size> findAllSize() {
        return sizeRepository.findAll();
    }

    @Override
    public void deleteByIdSize(Long id) {
        sizeRepository.deleteById(id);
    }
}
