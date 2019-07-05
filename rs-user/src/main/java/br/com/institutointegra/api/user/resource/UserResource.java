package br.com.institutointegra.api.user.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutointegra.api.user.model.User;
import br.com.institutointegra.api.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="User API", description = "Operations to User")
public class UserResource {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "View list User")
	@GetMapping("/all")
	public List<User> getAll(){
		return this.userService.getAll();
	}
	
	@PostMapping("/")
	public User save(@RequestBody User user) {
		return this.userService.save(user);
	}
	
	@PutMapping("/{id}")
	public User update(
			@PathVariable(name = "id", required = false) Long idUser, 
			@RequestBody User user
			) {
		return this.userService.save(user);
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return this.userService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  delete(@PathVariable Long id) {
		this.userService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}


