package beanWood.springBoot.wishList.controller;

import beanWood.springBoot.wishList.model.WishList;
import beanWood.springBoot.wishList.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wishList")
public class WishListControllerImpl implements WishListController {
	@Autowired
	private WishListService wishListService;

	@Override
	@PostMapping("/save")
	public WishList saveWishList(@RequestBody WishList wishList) {
		return wishListService.saveWishList(wishList);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<WishList> findByIdWishList(@PathVariable Long id) {
		return wishListService.findByIdWishList(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<WishList> findAllWishList() {
		return wishListService.findAllWishList();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdWishList(@PathVariable Long id) {
		wishListService.deleteByIdWishList(id);
	}
}
