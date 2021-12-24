package beanWood.springBoot.cartList.service;

import beanWood.springBoot.cartList.model.CartList;
import beanWood.springBoot.cartList.repository.CartListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartListServiceImpl implements CartListService {
	@Autowired
	private CartListRepository cartListRepository;

	@Override
	public CartList saveCartList(CartList cartList) {
		return cartListRepository.save(cartList);
	}

	@Override
	public Optional<CartList> findByIdCartList(Long id) {
		return cartListRepository.findById(id);
	}

	@Override
	public List<CartList> findAllCartList() {
		return cartListRepository.findAll();
	}

	@Override
	public void deleteByIdCartList(Long id) {
		cartListRepository.deleteById(id);
	}
}
