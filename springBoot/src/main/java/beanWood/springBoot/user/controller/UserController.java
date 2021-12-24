package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserController {
    User saveUser(User user);
    Optional<User> findByIdUser(Long id);
    List<User> findAllUser();
    void deleteByIdUser(Long id);

}
