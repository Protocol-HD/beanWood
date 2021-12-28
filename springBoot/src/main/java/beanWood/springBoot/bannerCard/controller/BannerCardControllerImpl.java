package beanWood.springBoot.bannerCard.controller;

import beanWood.springBoot.bannerCard.dto.IBannerCard;
import beanWood.springBoot.bannerCard.model.BannerCard;
import beanWood.springBoot.bannerCard.service.BannerCardService;
import beanWood.springBoot.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/bannerCard")
@RequiredArgsConstructor
public class BannerCardControllerImpl implements BannerCardController {
	private final BannerCardService bannerCardService;
	private final ImageService imageService;

	@Override
	@PostMapping("/save")
	public BannerCard saveBannerCard(@RequestBody IBannerCard iBannerCard) {
		return bannerCardService.saveBannerCard(
				BannerCard.builder()
						.image(imageService.findByIdImage(iBannerCard.getImageId()).get())
						.tag(iBannerCard.getTag())
						.text(iBannerCard.getText())
						.title(iBannerCard.getTitle())
						.build()
		);

	}

	@Override
	@PutMapping("/update")
	public BannerCard updateBannerCard(@RequestBody IBannerCard iBannerCard) {
		return bannerCardService.saveBannerCard(
				BannerCard.builder()
						.id(iBannerCard.getId())
						.image(imageService.findByIdImage(iBannerCard.getImageId()).get())
						.tag(iBannerCard.getTag())
						.text(iBannerCard.getText())
						.title(iBannerCard.getTitle())
						.build()
		);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<BannerCard> findByBannerCard(@PathVariable Long id) {
		return bannerCardService.findByIdBannerCard(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<BannerCard> findAllBannerCard() {
		return bannerCardService.findBannerCard();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdBannerCard(@PathVariable Long id) {
		bannerCardService.deleteByIdBannerCard(id);
	}
}
