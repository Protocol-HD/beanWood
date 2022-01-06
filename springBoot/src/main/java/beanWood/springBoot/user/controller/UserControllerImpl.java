package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.model.IUser;
import beanWood.springBoot.user.model.User;
import beanWood.springBoot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
	private final UserService userService;

//	@Override
//	@PostMapping("/save")
//	public ResponseEntity<User> saveUser(@RequestBody User user) {
//		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
//		return ResponseEntity.created(uri).body(userService.saveUser(user));
//	}

	@Override
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody IUser iUser) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(iUser));
	}

	@Override
	@PutMapping("/update")
	public int updateUser(@RequestBody IUser iUser) {
		try {
			userService.saveUser(iUser);
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
	@GetMapping("/findByUserName/{userName}")
	public int findByUserName(@PathVariable String userName) {
		try {
			userService.findByUserName(userName);
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}
}
