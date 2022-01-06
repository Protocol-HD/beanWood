package beanWood.springBoot.user.controller;

import beanWood.springBoot.user.dto.RoleToUserForm;
import beanWood.springBoot.user.model.Role;
import beanWood.springBoot.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/role")
@RestController
@Slf4j
@CrossOrigin
public class RoleControllerImpl implements RoleController {
	private final RoleService roleService;

	@Override
	@PostMapping("/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
		return ResponseEntity.created(uri).body(roleService.saveRole(role));
	}

	@Override
	@PostMapping("/saveRoleToUser")
	public ResponseEntity<?> addRoleToUSer(@RequestBody RoleToUserForm roleToUserForm) {
		roleService.saveRoleByUserName(roleToUserForm.getUserName(), roleToUserForm.getRoleName());
		return ResponseEntity.ok().build();
	}
}
