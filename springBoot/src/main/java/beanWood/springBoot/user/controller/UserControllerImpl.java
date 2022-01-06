package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.model.User;
import beanWood.springBoot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
	private final UserService userService;

	@Override
	@PostMapping("/save")
	public int saveUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@PutMapping("/update")
	public int updateUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
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
	public int deleteByIdUser(@PathVariable Long id) {
		try {
			userService.deleteByIdUser(id);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@GetMapping("/findByUserId/{userId}")
	public int findByUserId(@PathVariable String userId) {
		try {
			userService.findByUserId(userId);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}
}
