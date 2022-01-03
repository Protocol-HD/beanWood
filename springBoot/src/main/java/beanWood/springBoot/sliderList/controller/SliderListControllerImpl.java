package beanWood.springBoot.sliderList.controller;

import beanWood.springBoot.sliderList.dto.ISliderList;
import beanWood.springBoot.sliderList.model.SliderList;
import beanWood.springBoot.sliderList.service.SliderListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/sliderList")
@RequiredArgsConstructor
public class SliderListControllerImpl implements SliderListController {
	private final SliderListService sliderListService;

	@Override
	@PostMapping("/save")
	public SliderList saveSliderList(@RequestBody ISliderList iSliderList) {
		return sliderListService.saveSliderList(iSliderList);
	}

	@Override
	@PutMapping("/update")
	public SliderList updateSliderList(@RequestBody ISliderList iSliderList) {
		return sliderListService.saveSliderList(iSliderList);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<SliderList> findByIdSliderList(@PathVariable Long id) {
		return sliderListService.findByIdSliderList(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<SliderList> findAllSliderList() {
		return sliderListService.findAllSliderList();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdSliderList(@PathVariable Long id) {
		sliderListService.deleteByIdSliderList(id);
	}
}
