package beanWood.springBoot.product.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productName;
	private int price;
	private boolean isNew;
	private int sale;
	private int star;
	private Long categoryId;
	private Long colorId;
	private Long sizeId;
}
