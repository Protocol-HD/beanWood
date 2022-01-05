package beanWood.springBoot.cartList.repository;

import beanWood.springBoot.cartList.model.CartList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartListRepository extends JpaRepository<CartList, Long> {
	List<CartList> findByProductId(Long productId);
}
