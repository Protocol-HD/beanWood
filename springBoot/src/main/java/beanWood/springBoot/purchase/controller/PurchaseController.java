package beanWood.springBoot.purchase.controller;

import beanWood.springBoot.purchase.dto.PurchaseDto;
import beanWood.springBoot.purchase.model.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseController {
    int savePurchase(PurchaseDto purchaseDto);

    Optional<Purchase> findByIdPurchase(Long id);

    List<Purchase> findAllPurchase();

    int deleteByIdPurchase(Long id);
}
