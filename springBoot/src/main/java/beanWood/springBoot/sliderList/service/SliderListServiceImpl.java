package beanWood.springBoot.sliderList.service;

import beanWood.springBoot.image.service.ImageService;
import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.sliderList.dto.ISliderList;
import beanWood.springBoot.sliderList.model.SliderList;
import beanWood.springBoot.sliderList.repository.SliderListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SliderListServiceImpl implements SliderListService {
	private final SliderListRepository sliderListRepository;
	private final ProductService productService;
	private final ImageService imageService;

	@Override
	public SliderList saveSliderList(ISliderList iSliderList) {
		return sliderListRepository.save(
				SliderList.builder()
						.id(iSliderList.getId())
						.eventName(iSliderList.getEventName())
						.product(productService.findByIdProduct(iSliderList.getProductId()).get())
						.image(imageService.findByIdImage(iSliderList.getImageId()).get())
						.build()
		);
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
