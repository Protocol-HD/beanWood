package beanWood.springBoot.color.controller;

import beanWood.springBoot.color.model.Color;
import beanWood.springBoot.color.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/color")
@RequiredArgsConstructor
public class ColorControllerImpl implements ColorController {
	private final ColorService colorService;

	@Override
	@PostMapping("/save")
	public Color saveColor(@RequestBody Color color) {
		return colorService.saveColor(color);
	}

	@Override
	@PutMapping("/update")
	public Color updateColor(@RequestBody Color color) {
		return saveColor(color);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<Color> findByIdColor(@PathVariable Long id) {
		return colorService.findByIdColor(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<Color> findAllColor() {
		return colorService.findAllColor();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdColor(@PathVariable Long id) {
		colorService.deleteByIdColor(id);
	}
}
