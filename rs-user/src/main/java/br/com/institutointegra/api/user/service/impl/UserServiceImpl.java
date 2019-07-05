package br.com.institutointegra.api.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.institutointegra.api.user.model.User;
import br.com.institutointegra.api.user.repository.UserRepository;
import br.com.institutointegra.api.user.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User save(User p) {
		return this.userRepository.save(p);
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.userRepository.deleteById(id);
	}

}
