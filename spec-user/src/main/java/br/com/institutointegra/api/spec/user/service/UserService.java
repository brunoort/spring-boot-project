package br.com.institutointegra.api.spec.user.service;

import java.util.List;
import java.util.Map;

import br.com.institutointegra.api.spec.user.dto.UserDto;

public interface UserService {
	UserDto save(UserDto userDto);
	UserDto saveFeign(UserDto userDto);
	List<UserDto> listUser();
	Map<String, String> viewPort();
}
