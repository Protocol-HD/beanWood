package beanWood.springBoot.color.service;

import beanWood.springBoot.color.model.Color;
import beanWood.springBoot.color.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
	private final ColorRepository colorRepository;

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
