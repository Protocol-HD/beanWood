package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.dto.IUser;
import beanWood.springBoot.user.dto.OUser;
import beanWood.springBoot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
	public int saveUser(@RequestBody IUser iUser) {
		try {
			URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
			ResponseEntity.created(uri).body(userService.saveUser(iUser));
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@PutMapping("/update")
	public int updateUser(@RequestBody IUser iUser) {
		try {
			if(userService.saveUser(iUser) == null) return 2;
			return 1;
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return 2;
		}
	}

	@Override
	@GetMapping("/find/{id}")
<<<<<<< HEAD
	public OUser findByIdUser(@PathVariable Long id) {
		return userService.findByIdUser(id);
=======
	public Optional<User> findByIdUser(@PathVariable Long id) {
		try {
			return userService.findByIdUser(id);
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return Optional.empty();
		}
>>>>>>> 385f4656df69e40e7353527a622eebc372aa558b
	}

	@Override
	@GetMapping("/findAll")
<<<<<<< HEAD
	public List<OUser> findAllUser() {
		return userService.findAllUser();
=======
	public List<User> findAllUser() {
		try {
			return userService.findAllUser();
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return null;
		}
>>>>>>> 385f4656df69e40e7353527a622eebc372aa558b
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
<<<<<<< HEAD
	public OUser findByUserName(@PathVariable String userName) {
		return userService.findByUserName(userName);
=======
	public User findByUserName(@PathVariable String userName) {
		try {
			return userService.findByUserName(userName);
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return null;
		}
>>>>>>> 385f4656df69e40e7353527a622eebc372aa558b
	}
}
