package beanWood.springBoot.user.service;

import beanWood.springBoot.user.model.User;
import beanWood.springBoot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findByIdUser(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteByIdUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
}
