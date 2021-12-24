package beanWood.springBoot.size.model;

import beanWood.springBoot.product.model.Product;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sizeName;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Product product;

    public Size() {
    }

    @Builder
    public Size(String sizeName, Product product) {
        this.sizeName = sizeName;
        this.product = product;
    }
}
