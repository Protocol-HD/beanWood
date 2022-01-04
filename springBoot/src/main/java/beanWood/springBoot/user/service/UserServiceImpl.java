package beanWood.springBoot.user.service;

import beanWood.springBoot.user.model.User;
import beanWood.springBoot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		log.info("save User: {}", user.getUserId());
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findByIdUser(Long id) {
		log.info("find by id User: {}", id);
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAllUser() {
		log.info("find all User");
		return userRepository.findAll();
	}

	@Override
	public void deleteByIdUser(Long id) {
		log.info("delete by id User: {}", id);
		userRepository.deleteById(id);
	}

	@Override
	public User findByUserId(String userId) {
		log.info("find by UserId at User");
		return userRepository.findByUserId(userId);
	}
}
