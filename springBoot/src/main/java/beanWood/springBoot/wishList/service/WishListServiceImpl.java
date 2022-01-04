package beanWood.springBoot.wishList.service;

import beanWood.springBoot.product.service.ProductService;
import beanWood.springBoot.wishList.dto.IWishList;
import beanWood.springBoot.wishList.model.WishList;
import beanWood.springBoot.wishList.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishListServiceImpl implements WishListService {
	private final WishListRepository wishListRepository;
	private final ProductService productService;

	@Override
	public WishList saveWishList(IWishList iWishList) {
		log.info("save WishList: {}", iWishList);
		return wishListRepository.save(
				WishList.builder()
						.id(iWishList.getId())
						.product(productService.findByIdProduct(iWishList.getProductId()).get())
						.build()
		);
	}

	@Override
	public Optional<WishList> findByIdWishList(Long id) {
		log.info("fid by id WishList: {}", id);
		return wishListRepository.findById(id);
	}

	@Override
	public List<WishList> findAllWishList() {
		log.info("find all WishList");
		return wishListRepository.findAll();
	}

	@Override
	public void deleteByIdWishList(Long id) {
		log.info("delete by id WishList: {}", id);
		wishListRepository.deleteById(id);
	}
}
