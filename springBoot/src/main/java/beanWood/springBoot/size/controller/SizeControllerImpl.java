package beanWood.springBoot.size.controller;

import beanWood.springBoot.size.model.Size;
import beanWood.springBoot.size.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/size")
public class SizeControllerImpl implements SizeController {
	@Autowired
	private SizeService sizeService;

	@Override
	@PostMapping("/save")
	public Size saveSize(@RequestBody Size size) {
		return sizeService.saveSize(size);
	}

	@Override
	@PutMapping("/update")
	public Size updateSize(@RequestBody Size size) {
		return saveSize(size);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<Size> findByIdSize(@PathVariable Long id) {
		return sizeService.findByIdSize(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<Size> findAllSize() {
		return sizeService.findAllSize();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdSize(@PathVariable Long id) {
		sizeService.deleteByIdSize(id);
	}
}
