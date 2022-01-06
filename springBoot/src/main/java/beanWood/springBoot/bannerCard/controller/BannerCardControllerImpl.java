package beanWood.springBoot.bannerCard.controller;

import beanWood.springBoot.bannerCard.dto.IBannerCard;
import beanWood.springBoot.bannerCard.model.BannerCard;
import beanWood.springBoot.bannerCard.service.BannerCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/bannerCard")
@RequiredArgsConstructor
@Slf4j
public class BannerCardControllerImpl implements BannerCardController {
	private final BannerCardService bannerCardService;

	@Override
	@PostMapping("/save")
	public int saveBannerCard(@RequestBody IBannerCard iBannerCard) {
		try {
			bannerCardService.saveBannerCard(iBannerCard);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@PutMapping("/update")
	public int updateBannerCard(@RequestBody IBannerCard iBannerCard) {
		try {
			bannerCardService.saveBannerCard(iBannerCard);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
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
