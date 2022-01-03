package beanWood.springBoot.productColor.dto;

import lombok.Data;

@Data
public class IProductColor {
	private Long id;
	private Long productId;
	private Long colorId;
}
