package beanWood.springBoot.color.model;

import beanWood.springBoot.product.model.Product;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Color {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String colorName;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Product product;

    public Color() {
    }

    @Builder
    public Color(String colorName, Product product) {
        this.colorName = colorName;
        this.product = product;
    }
}
