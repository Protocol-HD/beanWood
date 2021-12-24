package beanWood.springBoot.category.model;

import beanWood.springBoot.image.model.Image;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Builder
    public Category(Image image) {
        this.image = image;
    }
}
