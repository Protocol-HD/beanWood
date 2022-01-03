package beanWood.springBoot.wishList.controller;

import beanWood.springBoot.wishList.dto.IWishList;
import beanWood.springBoot.wishList.model.WishList;
import beanWood.springBoot.wishList.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/wishList")
@RequiredArgsConstructor
public class WishListControllerImpl implements WishListController {
	private final WishListService wishListService;

	@Override
	@PostMapping("/save")
	public WishList saveWishList(@RequestBody IWishList iWishList) {
		return wishListService.saveWishList(iWishList);
	}

	@Override
	@PutMapping("/update")
	public WishList updateWishList(@RequestBody IWishList iWishList) {
		return wishListService.saveWishList(iWishList);
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
