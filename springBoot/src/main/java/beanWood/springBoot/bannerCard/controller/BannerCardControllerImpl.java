package beanWood.springBoot.bannerCard.controller;

import beanWood.springBoot.bannerCard.dto.IBannerCard;
import beanWood.springBoot.bannerCard.model.BannerCard;
import beanWood.springBoot.bannerCard.service.BannerCardService;
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

	@Override
	@PostMapping("/save")
	public BannerCard saveBannerCard(@RequestBody IBannerCard iBannerCard) {
		return bannerCardService.saveBannerCard(iBannerCard);
	}

	@Override
	@PutMapping("/update")
	public BannerCard updateBannerCard(@RequestBody IBannerCard iBannerCard) {
		return bannerCardService.saveBannerCard(iBannerCard);
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
