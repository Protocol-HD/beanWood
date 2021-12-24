package beanWood.springBoot.cartList.controller;

import beanWood.springBoot.cartList.dto.ICartList;
import beanWood.springBoot.cartList.model.CartList;
import beanWood.springBoot.cartList.service.CartListService;
import beanWood.springBoot.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartList")
public class CartListControllerImpl implements CartListController {
	@Autowired
	private CartListService cartListService;
	@Autowired
	private ProductService productService;

	@Override
	@PostMapping("/save")
	public CartList saveCartList(@RequestBody ICartList iCartList) {
		return cartListService.saveCartList(
				CartList.builder()
						.product(productService.findByIdProduct(iCartList.getProductId()).get())
						.quantity(iCartList.getQuantity())
						.build()
		);
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
