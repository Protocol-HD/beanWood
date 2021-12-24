package beanWood.springBoot.wishList.controller;

import beanWood.springBoot.wishList.dto.IWishList;
import beanWood.springBoot.wishList.model.WishList;

import java.util.List;
import java.util.Optional;

public interface WishListController {
	WishList saveWishList(IWishList IWishList);

	Optional<WishList> findByIdWishList(Long id);

	List<WishList> findAllWishList();

	void deleteByIdWishList(Long id);
}
