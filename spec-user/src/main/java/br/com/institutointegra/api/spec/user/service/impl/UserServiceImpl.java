package br.com.institutointegra.api.spec.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.institutointegra.api.spec.user.ProxyRsUser;
import br.com.institutointegra.api.spec.user.dto.UserDto;
import br.com.institutointegra.api.spec.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProxyRsUser proxyRsUser;
	

	@Override
	public Map<String, String> viewPort(){
		return this.proxyRsUser.viewPort();
	}
	
	 @Override
	 public UserDto save(UserDto userDto) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			 
			HttpEntity<UserDto> request = 
					 new HttpEntity<>(userDto, headers);
			 
			ResponseEntity<UserDto> entity = restTemplate.postForEntity(
					 "http://localhost:8080/api/", 
					 request, 
					 UserDto.class);
			
			return entity.getBody();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	 }

	@Override
	public UserDto saveFeign(UserDto userDto) {
		return this.proxyRsUser.save(userDto);
	}
	
	@Override
	public List<UserDto> listUser() {
		return this.proxyRsUser.listUser();
	}
	
}
