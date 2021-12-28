package beanWood.springBoot.sliderList.controller;

import beanWood.springBoot.sliderList.dto.ISliderList;
import beanWood.springBoot.sliderList.model.SliderList;

import java.util.List;
import java.util.Optional;

public interface SliderListController {
	SliderList saveSliderList(ISliderList isliderList);

	SliderList updateSliderList(ISliderList iSliderList);

	Optional<SliderList> findByIdSliderList(Long id);

	List<SliderList> findAllSliderList();

	void deleteByIdSliderList(Long id);
}
