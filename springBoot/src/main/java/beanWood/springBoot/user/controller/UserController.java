package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.model.IUser;
import beanWood.springBoot.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserController {
//	ResponseEntity<User> saveUser(User user);

	int saveUser(IUser iUser);

	int updateUser(IUser iUser);

	Optional<User> findByIdUser(Long id);

	List<User> findAllUser();

	int deleteByIdUser(Long id);

	User findByUserName(String userName);
}
