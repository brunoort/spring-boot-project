package br.com.institutointegra.api.spec.user;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.institutointegra.api.spec.user.dto.UserDto;

@FeignClient(
		url="${store.url.rs-user}",
		name="rs-user"
		)
@RibbonClient(name = "rs-user")
public interface ProxyRsUser {
	
	@PostMapping("/api/")
	UserDto save(@RequestBody UserDto userDto);
	
	@GetMapping("/api/all")
	List<UserDto> listUser();
	
	@GetMapping("/api/viewPort")
	Map<String, String> viewPort();
}
