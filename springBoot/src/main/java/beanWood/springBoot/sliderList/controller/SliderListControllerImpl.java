package beanWood.springBoot.sliderList.controller;

import beanWood.springBoot.image.service.ImageService;
import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.sliderList.dto.ISliderList;
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
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductService productService;


    @Override
    @PostMapping("/save")
    public SliderList saveSliderList(@RequestBody ISliderList isliderList) {
        return sliderListService.saveSliderList(
                SliderList.builder()
                          .eventName(isliderList.getEventName())
                          .image(imageService.findByIdImage(isliderList.getImageId()).get())
                          .product(productService.findByIdProduct(isliderList.getProductId()).get())
                          .build()
        );
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
