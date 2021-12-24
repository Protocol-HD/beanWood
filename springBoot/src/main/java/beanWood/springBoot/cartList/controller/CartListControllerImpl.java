package beanWood.springBoot.cartList.controller;

import beanWood.springBoot.cartList.model.CartList;
import beanWood.springBoot.cartList.service.CartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartList")
public class CartListControllerImpl implements CartListController {
	@Autowired
	private CartListService cartListService;

	@Override
	@PostMapping("/save")
	public CartList saveCartList(@RequestBody CartList cartList) {
		return cartListService.saveCartList(cartList);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<CartList> findByIdCartList(@PathVariable Long id) {
		return cartListService.findByIdCartList(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<CartList> findAllCartList() {
		return cartListService.findAllCartList();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdCartList(@PathVariable Long id) {
		cartListService.deleteByIdCartList(id);
	}
}
