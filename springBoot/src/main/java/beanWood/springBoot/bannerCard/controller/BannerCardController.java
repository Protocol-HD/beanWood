package beanWood.springBoot.bannerCard.controller;

import beanWood.springBoot.bannerCard.dto.IBannerCard;
import beanWood.springBoot.bannerCard.model.BannerCard;

import java.util.List;
import java.util.Optional;

public interface BannerCardController {
    BannerCard saveBannerCard(IBannerCard iBannerCard);

    BannerCard updateBannerCard(IBannerCard iBannerCard);

    Optional<BannerCard> findByBannerCard(Long id);

    List<BannerCard> findAllBannerCard();

    void deleteByIdBannerCard(Long id);
}