package beanWood.springBoot.size.controller;

import beanWood.springBoot.size.model.Size;
import beanWood.springBoot.size.service.SizeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/size")
@RequiredArgsConstructor
@Slf4j
public class SizeControllerImpl implements SizeController {
	private final SizeService sizeService;

	@Override
	@PostMapping("/save")
	public int saveSize(@RequestBody Size size) {
		try {
			sizeService.saveSize(size);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@PutMapping("/update")
	public int updateSize(@RequestBody Size size) {
		try {
			sizeService.saveSize(size);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
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
	public int deleteByIdSize(@PathVariable Long id) {
		try {
			sizeService.deleteByIdSize(id);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}
}
