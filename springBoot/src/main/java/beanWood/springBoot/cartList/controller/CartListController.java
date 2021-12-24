package beanWood.springBoot.cartList.controller;

import beanWood.springBoot.cartList.model.CartList;

import java.util.List;
import java.util.Optional;

public interface CartListController {
	CartList saveCartList(CartList cartList);

	Optional<CartList> findByIdCartList(Long id);

	List<CartList> findAllCartList();

	void deleteByIdCartList(Long id);
}
