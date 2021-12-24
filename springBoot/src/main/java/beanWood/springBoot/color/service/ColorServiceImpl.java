package beanWood.springBoot.color.service;

import beanWood.springBoot.color.model.Color;
import beanWood.springBoot.color.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {
	@Autowired
	private ColorRepository colorRepository;

	@Override
	public Color saveColor(Color color) {
		return colorRepository.save(color);
	}

	@Override
	public Optional<Color> findByIdColor(Long id) {
		return colorRepository.findById(id);
	}

	@Override
	public List<Color> findAllColor() {
		return colorRepository.findAll();
	}

	@Override
	public void deleteByIdColor(Long id) {
		colorRepository.deleteById(id);
	}
}
