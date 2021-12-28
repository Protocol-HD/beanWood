package beanWood.springBoot.wishList.controller;

import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.wishList.dto.IWishList;
import beanWood.springBoot.wishList.model.WishList;
import beanWood.springBoot.wishList.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/wishList")
public class WishListControllerImpl implements WishListController {
	@Autowired
	private WishListService wishListService;
	@Autowired
	private ProductService productService;

	@Override
	@PostMapping("/save")
	public WishList saveWishList(@RequestBody IWishList iWishList) {
		return wishListService.saveWishList(
				WishList.builder()
						.product(productService.findByIdProduct(iWishList.getProductId()).get())
						.build()
		);
	}

	@Override
	@PutMapping("/update")
	public WishList updateWishList(@RequestBody IWishList iWishList) {
		return wishListService.saveWishList(
				WishList.builder()
						.id(iWishList.getId())
						.product(productService.findByIdProduct(iWishList.getProductId()).get())
						.build()
		);
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
