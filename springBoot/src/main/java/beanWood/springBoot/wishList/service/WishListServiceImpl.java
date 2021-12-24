package beanWood.springBoot.wishList.service;

import beanWood.springBoot.wishList.model.WishList;
import beanWood.springBoot.wishList.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService {
	@Autowired
	private WishListRepository wishListRepository;

	@Override
	public WishList saveWishList(WishList wishList) {
		return wishListRepository.save(wishList);
	}

	@Override
	public Optional<WishList> findByIdWishList(Long id) {
		return wishListRepository.findById(id);
	}

	@Override
	public List<WishList> findAllWishList() {
		return wishListRepository.findAll();
	}

	@Override
	public void deleteByIdWishList(Long id) {
		wishListRepository.deleteById(id);
	}
}
