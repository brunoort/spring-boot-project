package br.com.institutointegra.api.spec.user.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutointegra.api.spec.user.dto.UserDto;
import br.com.institutointegra.api.spec.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	private UserService userService;
	

	@GetMapping("/viewPortUser")
	public Map<String, String> viewPortUser(){
		return this.userService.viewPort();
	}
	
	@PostMapping("/")
	public UserDto save(@RequestBody UserDto userDto) {
		return this.userService.save(userDto);
	}
	
	@PostMapping("/feign")
	public UserDto saveFeign(@RequestBody UserDto userDto) {
		return this.userService.saveFeign(userDto);
	}
	
	@GetMapping("/all")
	public List<UserDto> listClient(){
		return this.userService.listUser(); 
	}
		
}
