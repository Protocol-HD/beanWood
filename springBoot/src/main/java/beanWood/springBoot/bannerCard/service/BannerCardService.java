package beanWood.springBoot.bannerCard.service;

import beanWood.springBoot.bannerCard.model.BannerCard;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BannerCardService {
     BannerCard saveBannerCard(BannerCard bannerCard);

     Optional<BannerCard> findByIdBannerCard(Long id);

     List<BannerCard> findBannerCard();

     void deleteByIdBannerCard(Long id);
}
