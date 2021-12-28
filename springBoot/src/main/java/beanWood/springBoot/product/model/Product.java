package beanWood.springBoot.product.model;

import beanWood.springBoot.category.model.Category;
import beanWood.springBoot.color.model.Color;
import beanWood.springBoot.size.model.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productName;
	private int price;
	private boolean isNew;
	private int sale;
	private int star;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	@ManyToOne
	@JoinColumn(name = "size_id")
	private Size size;

	@Builder
	public Product(Long id, String productName, int price, boolean isNew, int sale, int star, Category category, Color color, Size size) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.isNew = isNew;
		this.sale = sale;
		this.star = star;
		this.category = category;
		this.color = color;
		this.size = size;
	}
}
