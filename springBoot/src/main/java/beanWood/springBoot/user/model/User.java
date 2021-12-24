package beanWood.springBoot.user.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String userPassword;
    private String userAddress;
    private boolean isAdmin;

    public User() {
    }

    @Builder
    public User(String userId, String userPassword, String userAddress, boolean isAdmin) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.isAdmin = isAdmin;
    }
}
