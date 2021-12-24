package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.model.User;
import beanWood.springBoot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/save")
    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    @PostMapping("/find/{id}")
    public Optional<User> findByIdUser(Long id) {
        return userService.findByIdUser(id);
    }

    @Override
    @PostMapping("/findAll")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @Override
    @PostMapping("/delete/{id}")
    public void deleteByIdUser(Long id) {
        userService.deleteByIdUser(id);
    }
}
