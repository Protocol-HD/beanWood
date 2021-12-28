package beanWood.springBoot.size.controller;

import beanWood.springBoot.size.model.Size;

import java.util.List;
import java.util.Optional;

public interface SizeController {
	Size saveSize(Size size);

	Size updateSize(Size size);

	Optional<Size> findByIdSize(Long id);

	List<Size> findAllSize();

	void deleteByIdSize(Long id);
}
