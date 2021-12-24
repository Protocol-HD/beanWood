package beanWood.springBoot.bannerCard.service;

import beanWood.springBoot.bannerCard.model.BannerCard;
import beanWood.springBoot.bannerCard.repository.BannerCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerCardServiceImpl implements BannerCardService {
	@Autowired
	private BannerCardRepository bannerCardRepository;

	@Override
	public BannerCard saveBannerCard(BannerCard bannerCard) {
		return bannerCardRepository.save(bannerCard);
	}

	@Override
	public Optional<BannerCard> findByIdBannerCard(Long id) {
		return bannerCardRepository.findById(id);
	}

	@Override
	public List<BannerCard> findBannerCard() {
		return bannerCardRepository.findAll();
	}

	@Override
	public void deleteByIdBannerCard(Long id) {
		bannerCardRepository.deleteById(id);
	}
}
