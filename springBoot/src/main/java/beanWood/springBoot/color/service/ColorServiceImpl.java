package beanWood.springBoot.color.service;

import beanWood.springBoot.color.model.Color;
import beanWood.springBoot.color.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
	private final ColorRepository colorRepository;

	@Override
	public Color saveColor(Color color) {
		log.info("save Color successfully: {}", color);
		return colorRepository.save(color);
	}

	@Override
	public Optional<Color> findByIdColor(Long id) {
		log.info("find by id Color: {}", id);
		return colorRepository.findById(id);
	}

	@Override
	public List<Color> findAllColor() {
		log.info("find all Color");
		return colorRepository.findAll();
	}

	@Override
	public void deleteByIdColor(Long id) {
		log.info("delete by id Color: {}", id);
		colorRepository.deleteById(id);
	}
}
