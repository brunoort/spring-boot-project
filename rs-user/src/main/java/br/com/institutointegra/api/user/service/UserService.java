package br.com.institutointegra.api.user.service;

import java.util.List;

import br.com.institutointegra.api.user.model.User;

public interface UserService {
	List<User> getAll();
	
	User save(User p);
	
	User findById(Long id);
	
	void delete(Long id);
}


