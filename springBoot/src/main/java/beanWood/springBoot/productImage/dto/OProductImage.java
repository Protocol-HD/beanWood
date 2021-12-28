package beanWood.springBoot.productImage.dto;

import beanWood.springBoot.image.model.Image;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OProductImage {
	private Long id;
	private Image image;
	private Long productId;

	@Builder
	public OProductImage(Long id, Image image, Long productId) {
		this.id = id;
		this.image = image;
		this.productId = productId;
	}
}
