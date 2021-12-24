package beanWood.springBoot.sliderList.service;

import beanWood.springBoot.sliderList.model.SliderList;
import beanWood.springBoot.sliderList.repository.SliderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SliderListServiceImpl implements SliderListService {
    @Autowired
    private SliderListRepository sliderListRepository;

    @Override
    public SliderList saveSliderList(SliderList sliderList) {
        return sliderListRepository.save(sliderList);
    }

    @Override
    public Optional<SliderList> findByIdSliderList(Long id) {
        return sliderListRepository.findById(id);
    }

    @Override
    public List<SliderList> findAllSliderList() {
        return sliderListRepository.findAll();
    }

    @Override
    public void deleteByIdSliderList(Long id) {
        sliderListRepository.deleteById(id);
    }
}
