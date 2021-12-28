package beanWood.springBoot.product.dto;

import lombok.Data;

@Data
public class IProduct {
	private Long id;
	private String productName;
	private int price;
	private boolean isNew;
	private int sale;
	private int star;
	private Long productImageId;
	private Long categoryId;
	private Long colorId;
	private Long sizeId;
}
