package beanWood.springBoot.cartList.service;

import beanWood.springBoot.cartList.dto.ICartList;
import beanWood.springBoot.cartList.model.CartList;
import beanWood.springBoot.cartList.repository.CartListRepository;
import beanWood.springBoot.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartListServiceImpl implements CartListService {
	private final CartListRepository cartListRepository;
	private final ProductService productService;

	@Override
	public CartList saveCartList(ICartList iCartList) {
		log.info("save CartList: {}", iCartList.getId());
		return cartListRepository.save(
				CartList.builder()
						.id(iCartList.getId())
						.quantity(iCartList.getQuantity())
						.product(productService.findByIdProduct(iCartList.getProductId()).get())
						.build()
		);
	}

	@Override
	public Optional<CartList> findByIdCartList(Long id) {
		log.info("find CartList By Id: {}", id);
		return cartListRepository.findById(id);
	}

	@Override
	public List<CartList> findAllCartList() {
		log.info("find all CartList");
		return cartListRepository.findAll();
	}

	@Override
	public void deleteByIdCartList(Long id) {
		log.info("delete CartList By Id", id);
		cartListRepository.deleteById(id);
	}
}
