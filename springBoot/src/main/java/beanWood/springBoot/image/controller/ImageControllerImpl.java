package beanWood.springBoot.image.controller;

import beanWood.springBoot.image.model.Image;
import beanWood.springBoot.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageControllerImpl implements ImageController {
	private final ImageService imageService;

	@Override
	@PostMapping("/save")
	public Image saveImage(@RequestBody Image image) {
		return imageService.saveImage(image);
	}

	@Override
	@PutMapping("/update")
	public Image updateImage(@RequestBody Image image) {
		return saveImage(image);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<Image> findByIdImage(@PathVariable Long id) {
		return imageService.findByIdImage(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<Image> findAllImage() {
		return imageService.findAllImage();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdImage(@PathVariable Long id) {
		imageService.deleteByIdImage(id);
	}
}
