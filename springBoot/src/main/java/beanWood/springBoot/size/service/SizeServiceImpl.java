package beanWood.springBoot.size.service;

import beanWood.springBoot.size.model.Size;
import beanWood.springBoot.size.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SizeServiceImpl implements SizeService {
	private final SizeRepository sizeRepository;

	@Override
	public Size saveSize(Size size) {
		log.info("save Size: {}", size.getSizeName());
		return sizeRepository.save(size);
	}

	@Override
	public Optional<Size> findByIdSize(Long id) {
		log.info("find by id Size: {}", id);
		return sizeRepository.findById(id);
	}

	@Override
	public List<Size> findAllSize() {
		log.info("find all Size");
		return sizeRepository.findAll();
	}

	@Override
	public void deleteByIdSize(Long id) {
		log.info("delete by id Size");
		sizeRepository.deleteById(id);
	}
}
