package beanWood.springBoot.purchase.dto;

import lombok.Data;

@Data
public class PurchaseDto {
    private Long id;
    private Long userId;
    private Long cartListId;
    private String shipMemo;
}
