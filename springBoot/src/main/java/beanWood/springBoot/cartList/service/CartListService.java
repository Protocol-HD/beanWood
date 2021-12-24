package beanWood.springBoot.cartList.service;

import beanWood.springBoot.cartList.model.CartList;

import java.util.List;
import java.util.Optional;

public interface CartListService {
	CartList saveCartList(CartList cartList);

	Optional<CartList> findByIdCartList(Long id);

	List<CartList> findAllCartList();

	void deleteByIdCartList(Long id);
}
