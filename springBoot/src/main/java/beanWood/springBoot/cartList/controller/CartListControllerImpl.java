package beanWood.springBoot.cartList.controller;

import beanWood.springBoot.cartList.dto.ICartList;
import beanWood.springBoot.cartList.model.CartList;
import beanWood.springBoot.cartList.service.CartListService;
import beanWood.springBoot.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/cartList")
@RequiredArgsConstructor
public class CartListControllerImpl implements CartListController {
	private final CartListService cartListService;
	private final ProductService productService;

	@Override
	@PostMapping("/save")
	public CartList saveCartList(@RequestBody ICartList iCartList) {
		return cartListService.saveCartList(iCartList);
	}

	@Override
	@PutMapping("/update")
	public CartList updateCartList(@RequestBody ICartList iCartList) {
		return cartListService.saveCartList(iCartList);
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
