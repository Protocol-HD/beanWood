package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserController {
	int saveUser(User user);

	int updateUser(User user);

	Optional<User> findByIdUser(Long id);

	List<User> findAllUser();

	int deleteByIdUser(Long id);

	int findByUserId(String userId);
}
