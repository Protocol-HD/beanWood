package beanWood.springBoot.wishList.repository;

import beanWood.springBoot.wishList.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {
	List<WishList> findByProductId(Long productId);
}
