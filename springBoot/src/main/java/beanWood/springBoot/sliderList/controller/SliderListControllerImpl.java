package beanWood.springBoot.sliderList.controller;

import beanWood.springBoot.sliderList.model.SliderList;
import beanWood.springBoot.sliderList.service.SliderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sliderList")
public class SliderListControllerImpl implements SliderListController {
    @Autowired
    private SliderListService sliderListService;

    @Override
    @PostMapping("/save")
    public SliderList saveSliderList(@RequestBody SliderList sliderList) {
        return sliderListService.saveSliderList(sliderList);
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
