package br.com.institutointegra.api.spec.client.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.institutointegra.api.spec.client.ProxyRsClient;
import br.com.institutointegra.api.spec.client.dto.ClientDto;
import br.com.institutointegra.api.spec.client.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProxyRsClient proxyRsClient;
	

	@Override
	public Map<String, String> viewPort(){
		return this.proxyRsClient.viewPort();
	}
	
	 @Override
	 public ClientDto save(ClientDto clientDto) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			 
			HttpEntity<ClientDto> request = 
					 new HttpEntity<>(clientDto, headers);
			 
			ResponseEntity<ClientDto> entity = restTemplate.postForEntity(
					 "http://localhost:8081/api/", 
					 request, 
					 ClientDto.class);
			
			return entity.getBody();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	 }

	@Override
	public ClientDto saveFeign(ClientDto clientDto) {
		return this.proxyRsClient.save(clientDto);
	}
	
	@Override
	public List<ClientDto> listClient() {
		return this.proxyRsClient.listClient();
	}
	
}
