package beanWood.springBoot.sliderList.service;

import beanWood.springBoot.image.repository.ImageRepository;
import beanWood.springBoot.product.repository.ProductRepository;
import beanWood.springBoot.sliderList.dto.ISliderList;
import beanWood.springBoot.sliderList.model.SliderList;
import beanWood.springBoot.sliderList.repository.SliderListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SliderListServiceImpl implements SliderListService {
	private final SliderListRepository sliderListRepository;
	private final ProductRepository productRepository;
	private final ImageRepository imageRepository;

	@Override
	public SliderList saveSliderList(ISliderList iSliderList) {
		log.info("save SliderList: {}", iSliderList.getEventName());
		return sliderListRepository.save(
				SliderList.builder()
						.id(iSliderList.getId())
						.eventName(iSliderList.getEventName())
						.product(productRepository.findById(iSliderList.getProductId()).get())
						.image(imageRepository.findById(iSliderList.getImageId()).get())
						.build()
		);
	}

	@Override
	public Optional<SliderList> findByIdSliderList(Long id) {
		log.info("find by id SliderList: {}", id);
		return sliderListRepository.findById(id);
	}

	@Override
	public List<SliderList> findAllSliderList() {
		log.info("find all SliderList");
		return sliderListRepository.findAll();
	}

	@Override
	public void deleteByIdSliderList(Long id) {
		log.info("delete by id SliderList: {}", id);
		sliderListRepository.deleteById(id);
	}
}
