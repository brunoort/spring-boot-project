package br.com.institutointegra.api.spec.client.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutointegra.api.spec.client.dto.ClientDto;
import br.com.institutointegra.api.spec.client.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientResource {

	@Autowired
	private ClientService clientService;
	

	@GetMapping("/viewPortClient")
	public Map<String, String> viewPortClient(){
		return this.clientService.viewPort();
	}
	
	@PostMapping("/")
	public ClientDto save(@RequestBody ClientDto clientDto) {
		return this.clientService.save(clientDto);
	}
	
	@PostMapping("/feign")
	public ClientDto saveFeign(@RequestBody ClientDto clientDto) {
		return this.clientService.saveFeign(clientDto);
	}
	
	@GetMapping("/all")
	public List<ClientDto> listClient(){
		return this.clientService.listClient(); 
	}
		
}
