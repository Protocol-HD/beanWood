package beanWood.springBoot.purchase.service;

import beanWood.springBoot.cartList.model.CartList;
import beanWood.springBoot.cartList.repository.CartListRepository;
import beanWood.springBoot.product.repository.ProductRepository;
import beanWood.springBoot.purchase.dto.PurchaseDto;
import beanWood.springBoot.purchase.model.Purchase;
import beanWood.springBoot.purchase.repository.PurchaseRepository;
import beanWood.springBoot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final CartListRepository cartListRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Purchase savePurchase(PurchaseDto purchaseDto) {
        log.info("save Purchase: {}", purchaseDto);
        try {
            CartList cartList = cartListRepository.findById(purchaseDto.getCartListId()).get();
            return purchaseRepository.save(
                    Purchase.builder()
                            .id(purchaseDto.getId())
                            .shipMemo(purchaseDto.getShipMemo())
                            .quantity(cartList.getQuantity())
                            .product(cartList.getProduct())
                            .user(userRepository.findById(purchaseDto.getUserId()).get())
                            .build());
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Purchase> findByIdPurchase(Long id) {
        log.info("find Purchase By Id: {}", id);
        try {
            return purchaseRepository.findById(id);
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Purchase> findAllPurchase() {
        log.info("find all Order");
        try {
            return purchaseRepository.findAll();
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteByIdPurchase(Long id) {
        log.info("delete Order By Id: {}", id);
        try {
            purchaseRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
