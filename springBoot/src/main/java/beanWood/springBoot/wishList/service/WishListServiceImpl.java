package beanWood.springBoot.wishList.service;

import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.wishList.dto.IWishList;
import beanWood.springBoot.wishList.model.WishList;
import beanWood.springBoot.wishList.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {
	private final WishListRepository wishListRepository;
	private final ProductService productService;

	@Override
	public WishList saveWishList(IWishList iWishList) {
		return wishListRepository.save(
				WishList.builder()
						.id(iWishList.getId())
						.product(productService.findByIdProduct(iWishList.getProductId()).get())
						.build()
		);
	}

	@Override
	public Optional<WishList> findByIdWishList(Long id) {
		return wishListRepository.findById(id);
	}

	@Override
	public List<WishList> findAllWishList() {
		return wishListRepository.findAll();
	}

	@Override
	public void deleteByIdWishList(Long id) {
		wishListRepository.deleteById(id);
	}
}
