package beanWood.springBoot.user.service;

import beanWood.springBoot.user.model.Role;
import beanWood.springBoot.user.repository.RoleRepository;
import beanWood.springBoot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {
		log.info("save role: {}", role);
		return roleRepository.save(role);
	}

	@Override
	public void saveRoleByUserName(String userName, String roleName) {
		log.info("save role by userId: {}", userName);
		userRepository.findByUserName(userName).getRoles().add(roleRepository.findByRoleName(roleName));
	}
}
