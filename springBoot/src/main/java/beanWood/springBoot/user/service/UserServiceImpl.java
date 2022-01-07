package beanWood.springBoot.user.service;

import beanWood.springBoot.user.model.IUser;
import beanWood.springBoot.user.model.Role;
import beanWood.springBoot.user.model.User;
import beanWood.springBoot.user.repository.RoleRepository;
import beanWood.springBoot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("load user by username: {}", userName);
		try {
			User user = userRepository.findByUserName(userName);

			if (user == null) {
				log.error("user not found");
				throw new UsernameNotFoundException("user not found");
			} else {
				log.info("user founded: {}", userName);
			}

			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			user.getRoles().forEach(role -> {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			});

			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), authorities);
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return null;
		}
	}

//	@Override
//	public User saveUser(User user) {
//		log.info("save User: {}", user.getUserName());
//		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
//		return userRepository.save(user);
//	}

	@Override
	public User saveUser(IUser iUser) {
		log.info("save user: {}", iUser);
		try {
			iUser.setUserPassword(passwordEncoder.encode(iUser.getUserPassword()));
			List<Role> roles = new ArrayList<>();
			roles.add(roleRepository.findById(1L).get());
			return userRepository.save(User.builder()
					.userAddress(iUser.getUserAddress())
					.userName(iUser.getUserName())
					.name(iUser.getName())
					.userNumber(iUser.getUserNumber())
					.userPassword(iUser.getUserPassword())
					.roles(roles)
					.build());
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<User> findByIdUser(Long id) {
		log.info("find by id User: {}", id);
		try {
			return userRepository.findById(id);
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return null;
		}
	}

	@Override
	public List<User> findAllUser() {
		log.info("find all User");
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteByIdUser(Long id) {
		log.info("delete by id User: {}", id);
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
		}
	}

	@Override
	public User findByUserName(String userName) {
		log.info("find by UserId at User");
		try {
			return userRepository.findByUserName(userName);
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			return null;
		}
	}
}
