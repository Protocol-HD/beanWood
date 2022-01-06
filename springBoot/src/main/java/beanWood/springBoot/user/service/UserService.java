package beanWood.springBoot.user.service;

import beanWood.springBoot.user.model.IUser;
import beanWood.springBoot.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
//	User saveUser(User user);

	User saveUser(IUser iUser);

	Optional<User> findByIdUser(Long id);

	List<User> findAllUser();

	void deleteByIdUser(Long id);

	User findByUserName(String userName);
}
