package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.model.User;
import beanWood.springBoot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
	@Autowired
	private UserService userService;

	@Override
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<User> findByIdUser(@PathVariable Long id) {
		return userService.findByIdUser(id);
	}

	@Override
	@GetMapping("/findAll")
	public List<User> findAllUser() {
		return userService.findAllUser();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteByIdUser(@PathVariable Long id) {
		userService.deleteByIdUser(id);
	}
}
